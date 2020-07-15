package com.base.code.java8;

import com.base.code.entity.Person;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * <p>
 * 1.使用情境：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
 * <p>
 * 2.方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例
 * <p>
 * 3.使用格式：类(或对象)::方法名
 * <p>
 * 4.具体分为如下三种情况：
 * - 对象::非静态方法
 * - 类::静态方法
 * - 类::非静态方法
 * <p>
 * 5.方法引用的要求：接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值类型抱持一致(情况一和情况二)
 *
 * @author yhc
 * @create 2020-02-07 9:25
 */
public class MethodRefTest {

    /**
     * Function中的R apply(T t)
     * Person中的String getName()
     */
    @Test
    public void test07() {
        Function<Person, String> fun1 = (e) -> e.getName();
        Person tom = new Person("tom", 19);
        System.out.println(fun1.apply(tom));

        Person jerry = new Person("jerry", 20);
        Function<Person, String> fun2 = Person::getName;
        System.out.println(fun2.apply(jerry));
    }

    /**
     * BiPredicate中的boolean test(T t1,T t2)
     * String中的boolean t1.equals(t2)
     */
    @Test
    public void test06() {
        BiPredicate<String, String> bp1 = (s1, s2) -> s1.equals(s2);
        System.out.println(bp1.test("abc", "abc"));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("ccc", "ccc"));
    }

    /**
     * 情况三：类::实例方法
     * Comparator中的int compare(T t1,T t2)
     * String中的int t1.compareTo(t2)
     */
    @Test
    public void test05() {
        Comparator<Integer> com1 = (t1, t2) -> t1.compareTo(t2);
        System.out.println(com1.compare(5, 6));

        Comparator<Integer> com2 = Integer::compareTo;
        System.out.println(com2.compare(6, 5));
    }

    /**
     * Function中的R apply(T t)
     * Math中的Long round(Double d)
     */
    @Test
    public void test04() {
        Function<Double, Long> fun1 = d -> Math.round(d);
        System.out.println(fun1.apply(5.5));

        Function<Double, Long> fun2 = Math::round;
        System.out.println(fun2.apply(6.5));

    }

    /**
     * 情况二：类::静态方法
     * Comparator中的int compare(T t1,T t2);
     * Integer中的int compare(T t1,T t2);
     */
    @Test
    public void test03() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(5, 6));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(6, 5));

    }

    /**
     * Supplier中的T get()
     * Person 中的 getName()方法
     */
    @Test
    public void test02() {
        Supplier<String> sup1 = () -> new Person("tom", 18).getName();
        System.out.println(sup1.get());
        Person jerry = new Person("jerry", 20);
        Supplier<String> sup2 = jerry::getName;
        System.out.println(sup2.get());
    }

    /**
     * 情况一：对象::实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     */
    @Test
    public void test01() {
        Consumer<String> con1 = str -> System.out.println("hello world");
        con1.accept("hello world1");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("hello world2");
    }

}
