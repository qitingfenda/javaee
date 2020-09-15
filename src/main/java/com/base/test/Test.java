package com.base.test;

/**
 * @author yhc
 * @create 2020-08-26 15:17
 */
public class Test {

    @org.junit.Test
    public void listNodeTest() {
        System.out.print(null + "");
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
