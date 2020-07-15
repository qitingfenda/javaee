package com.base.code.java8;

import com.base.code.entity.Person;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * - 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致，抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 * - 如果把数组看作是一个特殊的类，则写法与构造器引用是一致的
 *
 * @author yhc
 * @create 2020-03-06 13:25
 */
public class ConstructorRefTest {

    @Test
    public void test04() {
        Function<Integer, String[]> fun1 = x -> new String[x];
        System.out.println(fun1.apply(11).length);

        System.out.println("***");

        Function<Integer, String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(22).length);
    }

    @Test
    public void test03() {
        BiFunction<String, Integer, Person> biFunction = Person::new;
        Person tom = biFunction.apply("tom", 12);
        System.out.println(tom);
    }

    @Test
    public void test02() {
        Function<String, Person> fun1 = name -> new Person(name);
        System.out.println(fun1.apply("tom"));

        System.out.println("***");

        Function<String, Person> fun2 = Person::new;
        System.out.println(fun2.apply("aaa"));
    }

    @Test
    public void test01() {
        Supplier<Person> sup1 = () -> new Person();
        System.out.println(sup1.get());

        System.out.println("***");

        Supplier<Person> sup2 = Person::new;
        System.out.println(sup2.get());
    }

}
