package com.base.code.io;

import java.io.*;

/**
 * 其它流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author yhc
 * @date 2019-11-20 14:51
 */
public class OtherStreamTest {


    public static void main(String[] args) {
        test03();
    }

    /**
     * 数据流
     * DataInputStream 和 DataOutputStream
     * 作用：用于读取或写出基本数据类型的变量或字符串
     * 注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
     */
    private static void test03() {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            dis = new DataInputStream(new FileInputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt"));
            dos = new DataOutputStream(new FileOutputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt"));
            dos.writeUTF("abc");
            dos.writeBoolean(true);
            dos.writeInt(123);
            dos.writeDouble(123.45);
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打印流：PrintStream 和 PringWriter
     * 提供了一系列重载的print() 和 println()
     */
    private static void test02() {
        PrintStream ps = null;
        try {
            // 创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时都会刷新输出缓冲区）
            ps = new PrintStream(new FileOutputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt"), true);
            // 把标准输出流改成文件
            System.setOut(ps);
            for (int i = 0; i < 255; i++) {
                // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0)
                    // 每50个数据换一行
                    System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }
    }

    /**
     * 标准的输入、输出流
     * System.in：标准的输入流，默认从键盘输入
     * System.out：标准的输出流，默认从控制台输出
     * System类的setIn(InputStream is) / setOut(PrintStream ps)方法重新指定输入和输出的流
     * 使用System.in--->转换流--->BufferedReader
     */
    private static void test01() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.err.println("请输入...");
                String str = br.readLine();
                if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
                    System.err.println("退出程序！");
                    break;
                }
                System.out.println(str.toUpperCase());
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
        }
    }


}
