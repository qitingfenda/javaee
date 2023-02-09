package com.base.code.other;

import cn.hutool.core.util.IdUtil;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.CLAHE;
import org.opencv.imgproc.Imgproc;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yhc
 * @create 2022-05-27 8:41
 */
@Slf4j
public class QRCodeUtil {
    /**
     * 默认放大倍数
     */
    private final static int TIMES = 4;

//    static {
//        // 加载Opencv的dll文件
//        URL url = ClassLoader.getSystemResource("lib/opencv_java3416.dll");
//        System.load(url.getPath());
//    }

    /**
     * 复杂图片二维码解析
     *
     * @param file
     * @return
     */
    public static String complexDecode(File file) {
        String tempFilePath = null;
        try {
            log.debug("QRCodeUtil -> complexDecode() fileName:{}", file.getName());
            tempFilePath = getFilePath(file.getName());
            //第一次解析：直接解析
            log.debug("QRCodeUtil -> complexDecode() firstDecode begin by:{}", file.getName());
            String codeDataByFirst = simpleDecode(file);
            if (codeDataByFirst != null) {
                return codeDataByFirst;
            }
            //第二次解析：定位图中二维码，截图放大
            log.debug("QRCodeUtil -> complexDecode() secondDecode begin by:{}", file.getName());
            piz(file.getAbsolutePath(), tempFilePath);
            String codeDataBySecond = simpleDecode(tempFilePath);
            if (codeDataBySecond != null) {
                return codeDataBySecond;
            }
            //第三次解析：将截图后二维码二值化
            log.debug("QRCodeUtil -> complexDecode() thirdDecode begin by:{}", file.getName());
            Mat mat = binarization(tempFilePath);
            String codeDataByThird = simpleDecode(tempFilePath);
            if (codeDataByThird != null) {
                return codeDataByThird;
            }
            //第四次解析: 进行限制对比度的自适应直方图均衡化处理
            log.debug("QRCodeUtil -> complexDecode() fourthDecode begin by:{}", file.getName());
            limitContrast(tempFilePath, mat);
            String codeDataByFourth = simpleDecode(tempFilePath);
            if (codeDataByFourth != null) {
                log.debug("QRCodeUtil -> complexDecode() fileName:{} state:{} result:{}", file.getName(), Boolean.TRUE, codeDataByFourth);
                return codeDataByFourth;
            }
            log.debug("QRCodeUtil -> complexDecode() fileName:{} state:{}", file.getName(), Boolean.FALSE);
        } finally {
            file.deleteOnExit();
            if (tempFilePath != null) {
                file = new File(tempFilePath);
                file.deleteOnExit();
            }
        }
        return null;
    }

    /**
     * 复杂图片二维码解析
     *
     * @param path
     * @return
     */
    public static String complexDecode(String path) {
        return complexDecode(new File(path));
    }

    /**
     * 复杂图片二维码解析
     *
     * @param originalFile
     * @return
     */
    public static String complexDecode(MultipartFile originalFile) {
        String filePath = getFilePath(originalFile.getOriginalFilename());
        File mkFile = new File(filePath);
        if (!mkFile.exists()) {
            mkFile.mkdir();
            log.debug("QRCodeUtil -> complexDecode() create temp file ready by:{}", originalFile.getOriginalFilename());
        }
        try {
            originalFile.transferTo(mkFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return complexDecode(mkFile);
    }

    /**
     * 简单二维码解析
     *
     * @param path
     * @return
     */
    public static String simpleDecode(String path) {
        return simpleDecode(new File(path));
    }

    /**
     * 简单二维码解析
     *
     * @param file
     * @return zxing解析率实测与opencv差不多。所以直接使用zxing解析
     * zxing版本高能提高识别率
     */
    public static String simpleDecode(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            return result.getText();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 获取临时文件存储地址
     */
    @SneakyThrows
    private static String getFilePath(String fileName) {
        String path = ResourceUtils.getFile("classpath:").getPath() + "/static/decodeWork/";
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String contentType = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
        String newFileName = IdUtil.getSnowflake(0, 0).nextId() + "." + contentType;
        return path + newFileName;
    }

    /**
     * 定位 - > 截取 -> 放大
     *
     * @param filePath
     * @param tempFilePath
     */
    private static void piz(String filePath, String tempFilePath) {
        Mat srcGray = new Mat();
        Mat src = Imgcodecs.imread(filePath, 1);
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        List<MatOfPoint> markContours = new ArrayList<MatOfPoint>();
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        URL url = ClassLoader.getSystemResource("lib/opencv_java3416.dll");
//        System.load(url.getPath());
        //图片太小就放大
        if (src.width() * src.height() < 90000) {
            Imgproc.resize(src, src, new Size(800, 600));
        }
        // 彩色图转灰度图
        Imgproc.cvtColor(src, srcGray, Imgproc.COLOR_RGB2GRAY);
        // 对图像进行平滑处理
        Imgproc.GaussianBlur(srcGray, srcGray, new Size(3, 3), 0);
        Imgproc.Canny(srcGray, srcGray, 112, 255);
        Mat hierarchy = new Mat();
        Imgproc.findContours(srcGray, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_NONE);

        for (int i = 0; i < contours.size(); i++) {
            MatOfPoint2f newMtx = new MatOfPoint2f(contours.get(i).toArray());
            RotatedRect rotRect = Imgproc.minAreaRect(newMtx);
            double w = rotRect.size.width;
            double h = rotRect.size.height;
            double rate = Math.max(w, h) / Math.min(w, h);
            // 长短轴比小于1.3，总面积大于60
            if (rate < 1.3 && w < srcGray.cols() / 4 && h < srcGray.rows() / 4 && Imgproc.contourArea(contours.get(i)) > 60) {
                // 计算层数，二维码角框有五层轮廓（有说六层），这里不计自己这一层，有4个以上子轮廓则标记这一点
                double[] ds = hierarchy.get(0, i);
                if (ds != null && ds.length > 3) {
                    int count = 0;
                    if (ds[3] == -1) {
                        //最外层轮廓排除
                        continue;
                    }
                    // 计算所有子轮廓数量
                    while ((int) ds[2] != -1) {
                        ++count;
                        ds = hierarchy.get(0, (int) ds[2]);
                    }
                    if (count >= 4) {
                        markContours.add(contours.get(i));
                    }
                }
            }
        }
        /*
         * 二维码有三个角轮廓，正常需要定位三个角才能确定坐标，本工具当识别到两个点的时候也将二维码定位出来；
         * 当识别到两个及两个以上点时，取两个点中间点，往四周扩散截取 当小于两个点时，直接返回
         */
        if (markContours.size() == 0) {
            return;
        } else if (markContours.size() == 1) {
            capture(markContours.get(0), src, tempFilePath);
        } else {
            List<MatOfPoint> threePointList = new ArrayList<>();
            threePointList.add(markContours.get(0));
            threePointList.add(markContours.get(1));
            capture(threePointList, src, tempFilePath);
        }
    }

    /**
     * 当只识别到二维码的两个定位点时，根据两个点的中点进行定位
     *
     * @param threePointList
     * @param src
     */
    private static void capture(List<MatOfPoint> threePointList, Mat src, String tempFilePath) {
        Point p1 = centerCal(threePointList.get(0));
        Point p2 = centerCal(threePointList.get(1));
        Point centerPoint = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        double width = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y) + 50;
        // 设置截取规则
        Rect roiArea = new Rect((int) (centerPoint.x - width) > 0 ? (int) (centerPoint.x - width) : 0,
                (int) (centerPoint.y - width) > 0 ? (int) (centerPoint.y - width) : 0, (int) (2 * width),
                (int) (2 * width));
        // 截取二维码
        Mat dstRoi = new Mat(src, roiArea);
        // 放大图片
        Imgproc.resize(dstRoi, dstRoi, new Size(TIMES * width, TIMES * width));
        Imgcodecs.imwrite(tempFilePath, dstRoi);
    }

    /**
     * 针对对比度不高的图片，只能识别到一个角的，直接以该点为中心截取
     *
     * @param matOfPoint
     * @param src
     * @param tempFilePath
     */
    private static void capture(MatOfPoint matOfPoint, Mat src, String tempFilePath) {
        Point centerPoint = centerCal(matOfPoint);
        int width = 200;
        Rect roiArea = new Rect((int) (centerPoint.x - width) > 0 ? (int) (centerPoint.x - width) : 0,
                (int) (centerPoint.y - width) > 0 ? (int) (centerPoint.y - width) : 0, (int) (2 * width),
                (int) (2 * width));
        // 截取二维码
        Mat dstRoi = new Mat(src, roiArea);
        // 放大图片
        Imgproc.resize(dstRoi, dstRoi, new Size(TIMES * width, TIMES * width));
        Imgcodecs.imwrite(tempFilePath, dstRoi);
    }

    /**
     * 获取轮廓的中心坐标
     *
     * @param matOfPoint
     * @return
     */
    private static Point centerCal(MatOfPoint matOfPoint) {
        double centerx = 0, centery = 0;
        MatOfPoint2f mat2f = new MatOfPoint2f(matOfPoint.toArray());
        RotatedRect rect = Imgproc.minAreaRect(mat2f);
        Point vertices[] = new Point[4];
        rect.points(vertices);
        centerx = ((vertices[0].x + vertices[1].x) / 2 + (vertices[2].x + vertices[3].x) / 2) / 2;
        centery = ((vertices[0].y + vertices[1].y) / 2 + (vertices[2].y + vertices[3].y) / 2) / 2;
        Point point = new Point(centerx, centery);
        return point;
    }

    /**
     * 二值化图像
     *
     * @param filePath 图像地址
     */
    private static Mat binarization(String filePath) {
        Mat mat = Imgcodecs.imread(filePath, 1);
        // 彩色图转灰度图
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);
        // 对图像进行平滑处理
        Imgproc.blur(mat, mat, new Size(3, 3));
        // 中值去噪
        Imgproc.medianBlur(mat, mat, 5);
        // 这里定义一个新的Mat对象，主要是为了保留原图，未下次处理做准备
        Mat mat2 = new Mat();
        // 根据OTSU算法进行二值化
        Imgproc.threshold(mat, mat2, 205, 255, Imgproc.THRESH_OTSU);
        // 生成二值化后的图像
        Imgcodecs.imwrite(filePath, mat2);
        return mat;
    }

    /**
     * 图像进行限制对比度的自适应直方图均衡化处理
     *
     * @param filePath
     */
    public static void limitContrast(String filePath, Mat mat) {
        CLAHE clahe = Imgproc.createCLAHE(2, new Size(8, 8));
        clahe.apply(mat, mat);
        Imgcodecs.imwrite(filePath, mat);
    }

    public static void main(String[] args) {
        String s = complexDecode("C:\\Users\\admin\\Desktop\\test.jpg");
        System.out.println(s);
    }
}
