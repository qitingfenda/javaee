package com.base.code.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2.格式：
 * ->：lambda操作符或箭头操作符
 * ->左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 * ->右边：lambda体（其实就是重写的抽象方法的方法体）
 * <p>
 * 3.lambda表达式的使用：（分为6种情况介绍）
 * - 总结：
 * ->左边：lambda形参列表的参数类型可以省略（类型推断），如果lambda形参列表只有一个参数，其一对()也可以省略
 * ->右边：lambda体应该使用一对{}包裹。如果lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字
 * <p>
 * 4.lambda表达式的本质：作为函数式接口的实例
 * <p>
 * 5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 *
 * @author yhc
 * @FunctionalInterface 注解用于检验是否是函数式接口，并且javadoc文档中会包含一条声明
 * <p>
 * 6.所以以前用匿名实现类表示的现在都可以用lambda表达式来写
 * @create 2020-01-11 15:55
 */
public class LambdaTest1 {

    /**
     * 语法格式六：Lambda 体只有一条执行语句时，return与大括号都可以省略
     */
    @Test
    public void test06() {
        Comparator<Integer> com = (o1, o2) -> o1.compareTo(o2);
        int result = com.compare(5, 6);
        System.out.println(result);
    }

    /**
     * 语法格式五：Lambda 需要两个以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test05() {
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int result = com.compare(5, 6);
        System.out.println(result);
    }

    /**
     * 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test04() {
        Consumer<String> c1 = str -> System.out.println(str);
        c1.accept("hello world");
    }

    /**
     * 语法格式三：数据类型可以省略，因为可以由编译器推断得出，程为类型推断
     */
    @Test
    public void test03() {
        Consumer<String> c1 = (str) -> System.out.println(str);
        c1.accept("hello world!");
    }

    /**
     * 语法格式二：Lambda 需要一个参数，但是没有返回值
     */
    @Test
    public void test02() {
        Consumer<String> c1 = (String str) -> System.out.println(str);
        c1.accept("hello world!");
    }

    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void test01() {
        Runnable r1 = () -> System.out.println("无参无返回值Test");
        Thread t1 = new Thread(r1);
        t1.start();
    }

}
