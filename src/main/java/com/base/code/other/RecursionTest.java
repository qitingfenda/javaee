package com.base.code.other;

/**
 * 递归
 *
 * @author yhc
 * @date 2019-06-20 10:54
 */
public class RecursionTest {
    public static void main(String[] args) {
//        int sum = sum(100);
        int i = test04(10);
        System.out.println(i);
    }

    /**
     * 斐波那斐数列
     * 1 1 2 3 5 8 13 21 34 55
     */
    public static int test04(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return test04(i - 1) + test04(i - 2);
        }
    }

    /**
     * 已知一个数列 f(0) = 1;f(1) = 4,f(n+2) = 2*f(n+1) + f(n);求f(10)
     */
    public static int test03(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 4;
        } else {
            return 2 * test03(i - 1) + test03(i - 2);
        }
    }

    /**
     * 计算1-100之间所有自然数的和
     */
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + sum(--num);
        }
    }
}
