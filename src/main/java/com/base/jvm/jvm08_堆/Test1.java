package com.base.jvm.jvm08_堆;

/**
 * @author yhc
 * @create 2020-09-16 10:06
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println("test1 start...");
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1 end...");
    }

}
