package com.base.code.java8;

import com.base.code.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 *
 * @author yhc
 * @create 2020-03-06 14:46
 */
public class StreamTest1 {

    /**
     * 排序
     */
    @Test
    public void test04() {
        // sorted() 自然排序
        List<Integer> list = Arrays.asList(4, 34, 34, 234, 4, 432, 43, 43, 434, 4324);
        list.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com) 定制排序
        List<Person> personList = Person.getPersonData();
        personList.stream()
                .sorted((o1, o2) -> o1.getAge() == o2.getAge() ?
                        o1.getName().compareTo(o2.getName()) :
                        o1.getAge() - o2.getAge())
                .forEach(System.out::println);
    }

    @Test
    public void test03() {
        // flatMap(Function f) - 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        List<Person> personList = Person.getPersonData();
        Stream<Person> stream = personList.stream();
        Stream<Stream<Character>> streamStream = stream.map(Person::getName).map(StreamTest1::fromStringToStream);
        // 遍历streamStream 方式一：
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();

        // 遍历streamStream 方式二：
        Stream<Character> characterStream = personList.stream().map(Person::getName).flatMap(StreamTest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    /**
     * 将字符串中的多个字符构成的集合转换为对应的Stream的实例
     */
    private static Stream<Character> fromStringToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 映射
     */
    @Test
    public void test02() {
        // map(Function f) - 接收一个函数作为参数，将元素转换成其它形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<Person> personList = Person.getPersonData();
        Stream<Person> stream = personList.stream();
        stream.filter(person -> person.getName().length() > 3).map(Person::getName).forEach(System.out::println);
    }

    @Test
    public void test01() {
        // filter - 接收lambda 从流中排除某些元素
        List<Person> personList = Person.getPersonData();
        Stream<Person> stream = personList.stream();
//        stream.filter(e -> e.getAge() > 18).forEach(System.out::println);
        // limit(n) - 截断流，时其元素不超过给定数量
//        stream.limit(2).forEach(System.out::println);
        // skip(n) - 跳过元素，返回一个移除了前n个元素的流如果不足n个则返回一个空流
//        stream.skip(3).forEach(System.out::println);
        // distinct() - 筛选，通过流生成元素的 hashCode() 和 equals() 去除重复元素
        List<Person> collect = stream.distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
