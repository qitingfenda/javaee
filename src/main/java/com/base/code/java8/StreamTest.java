package com.base.code.java8;

import com.base.code.entity.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与CPU打交道。集合关注的是数据的存储，与内存打交道
 *
 * 2
 * - Stream 自己不会存储元素。
 * - Stream 不会改变怨怼想，相反，他们会返回一个持有结果的新Stream
 * - Stream 操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * - Stream的实例化
 * - 一系列的中间操作（过滤、映射、...）
 * - 终止操作
 *
 * 4.说明：
 * - 一个中间操作链，对数据源的数据进行处理
 * - 一旦执行终止操作，就执行中间操作链，并产生结果。之后不会再被使用
 *
 * @author yhc
 * @create 2020-03-06 14:00
 */
public class StreamTest {

    /**
     * 创建Stream方式四：创建无限流
     */
    @Test
    public void test03() {
        // 迭代
        // 遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        // 生成
        // 生成10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /**
     * 创建Stream方式二：通过数组
     */
    @Test
    public void test02() {
        // 调用Arrays类的静态方法 Arrays.stream(T[] array)
        Person[] persons = new Person[10];
        Stream<Person> stream = Arrays.stream(persons);
    }

    /**
     * 创建Stream方式一：通过集合
     */
    @Test
    public void test01() {
        List<Person> personList = Person.getPersonData();
        // stream() 返回一个顺序流
        Stream<Person> stream = personList.stream();
        // parallelStream() 返回一个并行流
        Stream<Person> personStream = personList.parallelStream();
    }

}
