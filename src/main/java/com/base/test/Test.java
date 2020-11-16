package com.base.test;

/**
 * @author yhc
 * @create 2020-08-26 15:17
 */
public class Test {

    @org.junit.Test
    public void test03() {
        long e = 7;
        long n = 72;
        long d = 1;

        int num = 0;

        while (num < 3) {
            if ((d * e) % n == 1) {
                num++;
                System.out.println(d);
            }
            d++;
        }

    }

    @org.junit.Test
    public void listNodeTest() {
//        System.out.println((572662311 * 15) % 72);
    }

    public void test(String str){
        str = "bcd";
    }

    @org.junit.Test
    public void replaceSpace() {
        StringBuffer str = new StringBuffer("We Are Happy.");
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' ') {
                result += "%20";
            } else {
                result += c;
            }
        }
        System.out.println(result);
    }


    public static void main1(String[] args) {
        Test s = new Test();
        int[][] arr = new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        boolean flag = s.Find(6, arr);
        System.out.println(flag);

    }


    public boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] subArr = array[i];
            if (subArr.length < 1) {
                return false;
            }
            if (subArr[subArr.length - 1] < target) {
                continue;
            }
            for (int j = 0; j < subArr.length; j++) {
                System.out.println(subArr[j]);
                if (subArr[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

}
