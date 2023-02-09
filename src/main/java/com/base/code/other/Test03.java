package com.base.code.other;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yhc
 * @create 2021-12-17 15:05
 */
public class Test03 {


    @Test
    public void test02() {
        List<BigDecimal> list1 = new ArrayList<>();
        list1.add(new BigDecimal("5.3"));
        list1.add(new BigDecimal("2.3"));
        list1.add(new BigDecimal("5.6"));
        list1.add(new BigDecimal("5.7"));
        list1.add(new BigDecimal("5.3"));
        list1.add(new BigDecimal("5.3"));
        list1.add(new BigDecimal("5.1"));
        list1.add(new BigDecimal("5.3"));
        List<BigDecimal> list2 = new ArrayList<>(list1);
        List<BigDecimal> list3 = new ArrayList<>(list1);
        list1.sort((one, two) -> (one.compareTo(two) > 0 ? -1 : 1));
        System.out.println("list1：");
        System.out.println(list1);
        list2.sort((one, two) -> (one.compareTo(two) * -1));
        System.out.println("list2：");
        System.out.println(list2);
        list3.sort(Comparator.reverseOrder());
        System.out.println("list3：");
        System.out.println(list3);
    }


    @Test
    public void test01() {
//        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] arr = new Integer[]{2, 3, 4, 5, 6};

        List<Integer> list = Arrays.asList(arr);

        dfs(list, "");

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        List<Integer> list = Arrays.asList(arr);
        for (int i = 1; i < 10; i++) {
            System.out.println("第" + i + "批");
            List<Integer> patchList = getPatchList(list, i, 100);
            patchList.forEach(System.out::println);
        }
    }

    private static <T> List<T> getPatchList(List<T> list, int patch, int patchNumber) {
        int indexBegin = (patch - 1) * patchNumber;
        if (indexBegin > list.size() - 1) {
            return new ArrayList<>();
        }
        int indexEnd = patch * patchNumber;
        indexEnd = Math.min(indexEnd, list.size());
        return list.subList(indexBegin, indexEnd);
    }


    public static void dfs(List<Integer> candidate, String prefix) {
        if (prefix.length() != 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> temp = new LinkedList<>(candidate);
            int item = temp.remove(i);
            // 取出被删除的元素，这个元素当作⼀个组合⽤掉了
            dfs(temp, prefix + item + ",");
        }
    }


    private Integer[] method(Integer[] arr, int number) {
        Map<Integer, Integer[]> map = new HashMap<>(100);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < index; j++) {
//                arr[i]
            }
            index++;
        }

        return new Integer[0];
    }


}
