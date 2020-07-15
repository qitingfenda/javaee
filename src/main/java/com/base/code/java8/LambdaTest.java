package com.base.code.java8;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author yhc
 * @create 2020-01-08 11:11
 */
public class LambdaTest {

    @Test
    public void test02() {
        // 1.
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // 2.lambda表达式写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

        // 3.方法引用

        Comparator<Integer> com3 = Integer::compare;

        int result = com2.compare(11, 22);

        System.out.println(result);
    }

    @Test
    public void test01() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("abc");
            }
        };
        r1.run();

        System.out.println("-----------------------");

        Runnable r2 = () -> System.out.println("xyz");
        r2.run();

    }

}
