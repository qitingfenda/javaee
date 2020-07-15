package com.base.code.io;

import java.io.*;

/**
 * 字符流测试
 *
 * @author yhc
 * @date 2019-11-19 9:33
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        test04();
    }

    private static void test04() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1.创建File类的对象，指明读入和写出的文件
            File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
            File file1 = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt");
            // 不能使用字符流来处理图片等字节数据
//            File file = new File("C:\\Users\\七听芬达\\Pictures\\head.jpg");
//            File file1 = new File("C:\\Users\\七听芬达\\Pictures\\head1.jpg");
            // 2.创建输入流和输出流的对象
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            char[] buffer = new char[5];
            int len;
            // 3.数据的读入和写出
            while ((len = fr.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                fw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 从内存中写出数据到硬盘的文件里
     * 1.输出操作，对应的File可以不存在。并不会报异常
     * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
     * File对应的硬盘中的文件如果不存在：
     * - 如果流使用的构造器是：FileWriter(file, false);会对原有的文件覆盖
     * - 如果流使用的构造器是：FileWriter(file, true);不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    private static void test03() {
        FileWriter fw = null;
        try {
            // 1.提供File类的对象，指明写出到的文件
            File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt");
            // 2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            String str = "helloWorld!";
            // 写出的操作
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    // 关闭资源
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 对read()操作升级：使用read的重载方法
     * read(char[])读取的字符数
     */
    private static void test02() {
        FileReader fr = null;
        // 1.实例化File类的对象，指明要操作的文件
        try {
            File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据的读入
            char[] buffer = new char[5];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                // 方式一：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(buffer[i]);
//                }
                // 方式二：
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    // 4.关闭资源
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 1.read()的理解：返回读入的一个字符。如果打导文件末尾，返回-1
     * 2.异常的处理：为了保证资源一定可以执行关闭操作。需要使用try-catch-finally处理
     * 3.读入的文件一定要存在，否则就会报FileNotFoundException。
     */
    private static void test01() {
        FileReader fr = null;
        try {
            // 1.实例化File类的对象，指明要操作的文件
            File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据的读入
            // read()：返回读入的一个字符。如果打导文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    // 4.关闭资源
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
