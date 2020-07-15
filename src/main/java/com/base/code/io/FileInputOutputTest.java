package com.base.code.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流测试
 * 1.对于文本文件，使用字符流处理
 * 2.对于非文本文件，使用字节流处理
 *
 * @author yhc
 * @date 2019-11-19 14:35
 */
public class FileInputOutputTest {

    public static void main(String[] args) {
        test02();
    }

    private static void test02() {
        long start = System.currentTimeMillis();
        String target = "C:\\Users\\七听芬达\\Desktop\\target.avi";
        String dest = "C:\\Users\\七听芬达\\Desktop\\dest1.avi";
//        String target = "C:\\Users\\七听芬达\\Pictures\\head.jpg";
//        String dest = "C:\\Users\\七听芬达\\Pictures\\head1.jpg";
        copyFile(target, dest);
        long end = System.currentTimeMillis();
        System.out.println("时间为：" + (end - start) + "毫秒");
    }


    /**
     * 复制文件
     */
    private static void copyFile(String target, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(target);
            File file1 = new File(dest);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[10000];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test01() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
            File file1 = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt");
//            File file = new File("C:\\Users\\七听芬达\\Pictures\\head.jpg");
//            File file1 = new File("C:\\Users\\七听芬达\\Pictures\\head1.jpg");
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[16];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
