package com.base.code.io;

import java.io.*;

/**
 * 1.缓存流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用：提升流的读取、写入的速度
 * 原因：
 *
 * @author yhc
 * @date 2019-11-19 15:22
 */
public class BufferTest {

    public static void main(String[] args) {
        test02();
    }

    private static void test02() {
        String target = "C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt";
        String dest = "C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File(target)));
            bw = new BufferedWriter(new FileWriter(new File(dest)));
            // 方法一：
//            char[] buffer = new char[16];
//            int len;
//            while ((len = br.read(buffer)) != -1) {
//                bw.write(buffer, 0, len);
//            }
            // 方法二：
            String data;
            while ((data = br.readLine()) != null) {
                // 第一种换行
//                bw.write(data + "\n");
                // 第二种换行
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test01() {
        long start = System.currentTimeMillis();
        String target = "C:\\Users\\七听芬达\\Desktop\\target.avi";
        String dest = "C:\\Users\\七听芬达\\Desktop\\dest2.avi";
//        String target = "C:\\Users\\七听芬达\\Pictures\\head.jpg";
//        String dest = "C:\\Users\\七听芬达\\Pictures\\head2.jpg";
        copyFile(target, dest);
        long end = System.currentTimeMillis();
        System.out.println("时间为：" + (end - start) + "毫秒");
    }

    private static void copyFile(String target, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(target)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(dest)));
            // 读取，写入
            int len;
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭：现关外层的流，再关闭内层的流
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 关闭外层流的同时，内层流也会自动关闭。关于内层流的关闭，我们可以省略
//            try {
//                if (fis != null)
//                    fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fos != null)
//                    fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }

}
