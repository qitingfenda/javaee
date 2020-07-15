package com.base.code.other;


import com.base.code.entity.Goods;
import org.junit.Test;

import java.util.Arrays;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较：== 或 != 不能使用 > 或 <
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小
 * 如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 * <p>
 * 二、Comparable接口的使用
 *
 * @author yhc
 * @date 2019-08-21 9:23
 */
public class CompareTest {

    /**
     * Comparator接口的使用：定制排序
     * 1.背景：
     * 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
     * 那么可以考虑使用Comparator的对象来排序
     * 2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小
     * 如果返回0，表示相等
     * 返回负整数，表示o1小于o2
     */
    @Test
    public void test03() {
        String[] arr = new String[]{"AA", "EE", "BB", "MM", "CC", "DD"};
        Arrays.sort(arr, (o1, o2) -> -o1.compareTo(o2));
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 43);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparable接口的使用：
     * 1、String包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方法
     * 2、重写compareTo(obj)的规则：
     * 如果当前对象this大于形参对象obj，则返回正整数
     * 如果当前对象this小于形参对象obj，则返回负整数
     * 如果当前对象this等于形参队形obj，则返回零
     * <p>
     * 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
     * 在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test01() {
        String[] arr = new String[]{"AA", "EE", "BB", "MM", "CC", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
