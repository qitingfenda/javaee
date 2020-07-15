package com.base.code.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * @author yhc
 * @date 2019-12-09 9:45
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {
        test02();
    }

    /**
     * 插入操作
     */
    private static void test02() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt"), "rw");
            // 保存插入位置后面的字符
            raf.seek(3);
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder builder = new StringBuilder((int) new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt").length());
            if ((len = raf.read(buffer)) != -1) {
                builder.append(new String(buffer, 1, len));
            }
            // 调回指针
            raf.seek(3);
            // 插入
            raf.write("xyz".getBytes());
            // 将保存的字符写入
            raf.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test01() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt"), "r");
            raf2 = new RandomAccessFile(new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 1, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
