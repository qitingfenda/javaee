package com.base.code.other;

import jdk.nashorn.internal.ir.ForNode;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yhc
 * @create 2019-10-29 16:45
 */
public class Test02 {

    public static void main(String[] args) {

        int[] result = FindNumsAppearOnce(new int[]{3,6});
        System.out.println(result);
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
        HashMap<Integer, Integer> map = new HashMap(array.length);
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
