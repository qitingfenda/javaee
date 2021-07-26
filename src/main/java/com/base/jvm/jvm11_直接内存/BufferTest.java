package com.base.jvm.jvm11_直接内存;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * @author yhc
 * @create 2021-07-26 10:07
 */
public class BufferTest {

    private static final int BUFFER = 1024 * 1024 * 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("分配直接内存");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放!");
        byteBuffer = null;

        System.gc();
        scanner.next();
    }

}
