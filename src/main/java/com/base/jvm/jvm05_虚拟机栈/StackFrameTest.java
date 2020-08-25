package com.base.jvm.jvm05_虚拟机栈;

/**
 * @author yhc
 * @create 2020-08-19 9:09
 */
public class StackFrameTest {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        System.out.println("method1()开始执行...");
        method2();
        System.out.println("method1()执行结束...");
    }

    public static int method2() {
        System.out.println("method2()开始执行...");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2()即将结束...");
        return i + m;
    }

    public static double method3() {
        System.out.println("method3()开始执行...");
        double j = 20.0;
        System.out.println("method3()即将结束...");
        return j;
    }

}
