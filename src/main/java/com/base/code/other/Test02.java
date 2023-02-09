package com.base.code.other;


import org.junit.Test;

import java.time.YearMonth;
import java.util.*;

/**
 * @author yhc
 * @create 2019-10-29 16:45
 */
public class Test02 {


    @Test
    public void test04() {
        int a = 2;
        int b = 2;
        int c = 3;
        System.out.println(a == 1 && b == 2 || c == 3);
    }

    @Test
    public void test03() {
        String thisMonthFirstDay = YearMonth.now().atDay(1).toString();
        System.out.println(thisMonthFirstDay);
    }

    public static void main(String[] args) {
        int pageNo = 1;
        int pageSize = 100;

        int limitStart = (pageNo - 1) * pageSize;
        int limitEnd = limitStart + pageSize;

        // 客户数量
        int customerTotal = 10;
        // 订单数量
        int orderTotal = 5;
        // 线下订单数量
        int offlineOrderTotal = 6;
        // 产品数量
        int productTotal = 7;

        int total = customerTotal + orderTotal + offlineOrderTotal + productTotal;

        if (customerTotal - limitEnd >= 0) {
            System.out.println("查询customer,开始:" + limitStart + ",结束:" + limitEnd);
            return;
        } else {
            if (limitStart - customerTotal < 0) {
                System.out.println("查询customer,开始:" + limitStart + ",结束:" + customerTotal);
            }
            limitStart = limitStart - customerTotal < 0 ? 0 : limitStart - customerTotal;
            limitEnd -= customerTotal;
        }
        if (orderTotal - limitEnd >= 0) {
            System.out.println("查询order,开始:" + limitStart + ",结束:" + limitEnd);
            return;
        } else {
            if (limitStart - orderTotal < 0) {
                System.out.println("查询order,开始:" + limitStart + ",结束:" + orderTotal);
            }
            limitStart = limitStart - orderTotal < 0 ? 0 : limitStart - orderTotal;
            limitEnd -= orderTotal;
        }
        if (offlineOrderTotal - limitEnd >= 0) {
            System.out.println("查询offlineOrder,开始:" + limitStart + ",结束:" + limitEnd);
            return;
        } else {
            if (limitStart - offlineOrderTotal < 0) {
                System.out.println("查询offlineOrder,开始:" + limitStart + ",结束:" + offlineOrderTotal);
            }
            limitStart = limitStart - offlineOrderTotal < 0 ? 0 : limitStart - offlineOrderTotal;
            limitEnd -= offlineOrderTotal;
        }
        if (productTotal - limitEnd >= 0) {
            System.out.println("查询offlineOrder,开始:" + limitStart + ",结束:" + limitEnd);
            return;
        } else {
            if (limitStart - productTotal < 0) {
                System.out.println("查询product,开始:" + limitStart + ",结束:" + productTotal);
            }
            limitStart = limitStart - productTotal < 0 ? 0 : limitStart - productTotal;
            limitEnd -= productTotal;
        }

        System.out.println("还剩：" + (limitEnd - limitStart));
    }


    public static String PrintMinNumber(int[] numbers) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            int num = numbers[i];
            int a = 1;
            int b = (num / a) % 10;
            while (b != 0) {
                subList.add(b);
                a *= 10;
                b = (num / a) % 10;
            }
            Collections.reverse(subList);
            list.add(subList);
        }
        for (ArrayList<Integer> integers : list) {

        }
        return null;
    }

    public static int GetNumberOfK(int[] array, int k) {
        int result = 0;
        for (int i : array) {
            if (i == k) {
                result++;
            } else if (i > k) {
                break;
            }
        }
        return result;
    }

    public static int binarySearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int min, mid, max;
        min = 0;
        max = arr.length - 1;
        while (min <= max) {
            mid = (min + max) / 2;
            if (key > arr[mid]) {
                min = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int[] FindNumsAppearOnce(int[] array) {
        int[] result = new int[2];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i : array) {
            Integer v = map.get(i);
            if (v == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++v);
            }
        }
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value == 1) {
                result[index] = key;
                if (index == 1) {
                    break;
                }
                index++;
            }
        }
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) {
            return result;
        }
        int max = (int) Math.ceil(sum / 2.0);
        int index = 1;
        int sum1 = 0;
        ArrayList<Integer> list;
        for (int i = 1; i <= max; i++) {
            sum1 += i;
            if (sum1 == sum) {
                list = new ArrayList<>();
                for (int j = index; j <= i; j++) {
                    list.add(j);
                }
                result.add(list);
                index++;
                i = index - 1;
                sum1 = 0;
            } else if (sum1 > sum) {
                index++;
                i = index - 1;
                sum1 = 0;
            }
        }
        return result;
    }

    public static String ReverseSentence(String str) {
        StringBuilder result = new StringBuilder();
        if (str.isEmpty()) {
            return str;
        }
        String[] split = str.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            result.append(split[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static boolean IsContinuous(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        int realLength = 0;
        Integer max = null, min = null;
        for (int number : numbers) {
            if (number != 0) {
                realLength++;
                set.add(number);
                if (null == max) {
                    max = min = number;
                }
                max = number > max ? number : max;
                min = number < min ? number : min;
            }
        }
        if (realLength != set.size()) {
            return false;
        }
        if (numbers.length == set.size()) {

        }
        if (max - min > numbers.length - 1) {
            return false;
        }
        return true;
    }

    public static int LastRemaining_Solution(int n, int m) {
        m--;
        int x = m;
        if (n < 1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int i = 1; i < n; i++) {
            m = m % list.size();
            list.remove(m);
            m = m + x;
        }
        return list.get(0);
    }

    public static int StrToInt(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String substring = str.substring(0, 1);
        char begin = substring.toCharArray()[0];
        boolean flag = begin == '-' || begin == '+';
        if (flag) {
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        int result = 0;
        int a = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (48 <= chars[i] && chars[i] <= 57) {
                result = a * (chars[i] - '-') + result;
                a *= 10;
            } else {
                return 0;
            }
        }
        if (flag && "-".equals(substring)) {
            result = -1 * result;
        }
        return result;
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int left = 0, right = 1;
        int sum = left + right;
        int index = 2;
        while (n != index++) {
            left = right;
            right = sum;
            sum = left + right;
        }
        return sum;
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        Integer product = null;
        Integer x = null;
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int j = 0; j < array.length; j++) {
            int i = array[j];
            if (x != null && i == x) {
                continue;
            }
            int num = sum - i;
            if (num <= 0) {
                continue;
            }
            Integer value = map.get(num);
            if (value != null && value != j) {
                int m = num * i;
                if (product == null || m < product) {
                    product = m;
                    x = num;
                    result.clear();
                    result.add(i);
                    result.add(num);
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int x = 0, y = 0;
        int length = matrix.length * matrix[0].length;
        int num = 0;
        int index = 1;
        do {
            result.add(matrix[x][y]);
            num++;
            if (x == index - 1) {
                if (y < matrix[x].length - index) {
                    y++;
                    continue;
                } else {
                    x++;
                    continue;
                }
            }
            if (x < matrix.length - index && y == matrix[x].length - index) {
                x++;
                continue;
            }
            if (x == matrix.length - index) {
                if (y > index - 1) {
                    y--;
                    continue;
                } else {
                    x--;
                    continue;
                }
            }
            if (y == 0 && x > index) {
                x--;
                continue;
            }
            x = y = index;
            index++;
        } while (num != length);
        return result;
    }

    public static String replaceSpace(String s) {
        char[] array = s.toCharArray();
        StringBuilder a = new StringBuilder();
        for (char anArray : array) {
            if (anArray == ' ') {
                a.append("%20");
            } else {
                a.append(anArray);
            }
        }
        return a.toString();
    }

    public static int duplicate(int[] numbers) {
        if (numbers.length < 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>(numbers.length);
        int a = numbers[0];
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return a;
    }


}