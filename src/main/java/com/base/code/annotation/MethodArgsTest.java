package com.base.code.annotation;

import java.io.PrintStream;

/**
 * @author yhc
 * @date 2019-06-20 9:15
 */
public class MethodArgsTest {

    public static void main(String[] args) {
//        show("a", "b", "c");
//        int a = 10;
//        int b = 10;
//        test02(a, b);
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
        test03();
    }

    public static void test03() {
        char[] arr = new char[10];
        System.out.println(arr);
    }

    public static void test02(int a, int b) {
        PrintStream ps = new PrintStream(System.out) {

            @Override
            public void println(String x) {
                if ("a=10".equals(x)) {
                    x = "a=100";
                } else if ("b=10".equals(x)) {
                    x = "b=200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }

    public static void test01(int a, int b) {
        a *= 10;
        b *= 20;
        System.out.println(a);
        System.out.println(b);
        System.exit(0);
    }

    public static void show(String... strs) {
        System.out.println(strs[1]);
        System.out.println(strs);
    }

//    public static void show(String[] arr) {
//
//    }

}
