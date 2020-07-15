package com.base.code.other;


/**
 * @author yhc
 * @date 2019-06-13 10:03
 */
public class Test01 {

    public static void main(String[] args) {
        test03();
    }


    public static void test03() {
        char[] arr = new char[10];
        for (int e : arr) {
            System.out.println(e);
        }

        boolean[] barr = new boolean[10];
        boolean b1 = barr[2];
        System.out.println(b1);
    }

    public static void test02() {
        int num = 100;
        f:
        for (int i = 1; i <= num; i++) {
            int min = 2;
            int max = i - 1;
            if (min >= max) {
                System.out.println(i);
                continue;
            }
            for (int j = min; j <= max; j++) {
                if (i % j == 0) {
                    continue f;
                }
            }
            System.out.println(i);
        }
    }

    public static void test01() {
        int num = 9;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

}
