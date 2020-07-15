package com.base.code.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 四大基本函数式接口
 * <p>
 * 接口名                  参数类型    返回值类型   描述
 * Consumer<T>消费型接口     T           void    对类型为T的对象应用操作，包含方法：void accept(T t);
 * Supplier<T>攻击性接口     无           T      返回类型为T的对象，包含方法：T get()
 * Function<T,R>函数型接口   T            R      对类型为T的对象应用操作，并返回结果是R类型的对象，包含方法：R apply(T t)
 * Predicate<T>断定行接口    T         boolean   确定类型为T的对象是否满足某约束，并返回boolean值。包含方法：boolean test(T t)
 *
 * @author yhc
 * @create 2020-02-06 18:00
 */
public class LambdaTest2 {

    @Test
    public void test02() {
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("232");
        strList.add("ds");
        strList.add("ads");
        strList.add("hello");
        strList.add("df");
        strList.add("232");
        strList.add("3434");
        System.out.println(strList);
        filterString(strList, str -> str.length() > 2);
        System.out.println(strList);
    }

    private void filterString(List<String> list, Predicate<String> pre) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (!pre.test(next)) {
                iterator.remove();
            }
        }
    }

    @Test
    public void test01() {
        happyTime(500.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费：" + aDouble);
            }
        });

        happyTime(500.0, x -> System.out.println("消费：" + x));
    }

    private void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

}
