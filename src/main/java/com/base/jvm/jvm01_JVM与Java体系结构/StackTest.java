package com.base.jvm.jvm01_JVM与Java体系结构;

/**
 * @author yhc
 * @create 2020-07-31 10:07
 */
public class StackTest {

    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(k);
    }

}
