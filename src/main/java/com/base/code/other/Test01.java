package com.base.code.other;


import java.util.Arrays;

/**
 * @author yhc
 * @date 2019-06-13 10:03
 */
public class Test01 {

    public static void main(String[] args) {
        test04();
    }

    private static void test04() {
        int[] source = new int[]{0, 1, 0, 3, 12};
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 0) {
                // 第二次循环，用于交换下一个不是0的元素
                for (int j = i + 1; j < source.length; j++) {
                    if (source[j] != 0) {
                        // 交换位置
                        int temp = source[i];
                        source[i] = source[j];
                        source[j] = temp;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(source));
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
