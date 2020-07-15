package com.base.code.java8;

import com.base.code.entity.Person;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yhc
 * @create 2020-03-25 15:55
 */
public class StreamTest2 {

    /**
     * 收集
     */
    @Test
    public void test03() {
        List<Person> personList = Person.getPersonData();

        // collect(Collector c) - 将流转换为其它形式，接收一个Collector接口的实现
        List<Person> collect = personList.stream()
                .filter(x -> x.getAge() > 18)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<Person> personList = Person.getPersonData();

        // count - 返回流中元素的总个数
        long count = personList.stream().filter(x -> x.getAge() > 18).count();
        System.out.println(count);

        // max(Comparator c) - 返回流中最大值
        Optional<Person> max = personList.stream().max((o1, o2) -> o1.getAge() == o2.getAge() ?
                o1.getName().compareTo(o2.getName()) :
                o1.getAge() - o2.getAge());
        System.out.println(max);

        // min(Comparator c) - 返回流中最小值
        Optional<Person> min = personList.stream().min((o1, o2) -> o1.getAge() == o2.getAge() ?
                o1.getName().compareTo(o2.getName()) :
                o1.getAge() - o2.getAge());
        System.out.println(min);

        // forEach(Consumer c) - 内部迭代
        personList.forEach(System.out::println);
    }

    /**
     * 匹配与查找
     */
    @Test
    public void test01() {
        List<Person> personList = Person.getPersonData();

        // allMatch(Predicate p) - 检查是否匹配所有元素
        boolean allMatch = personList.stream().allMatch(x -> x.getAge() > 18);
        System.out.println(allMatch);

        // anyMatch(Predicate p) - 检查是否至少匹配一个元素
        boolean anyMatch = personList.stream().anyMatch(x -> x.getAge() > 18);
        System.out.println(anyMatch);

        // noneMatch(Predicate p) - 检查是否没有匹配的元素
        boolean noneMatch = personList.stream().noneMatch(x -> x.getAge() > 18);
        System.out.println(noneMatch);

        // findFirst - 返回第一个元素
        Optional<Person> first = personList.stream().findFirst();
        System.out.println(first);

        // findAny - 返回当前流中的任意元素
        Optional<Person> any = personList.parallelStream().findAny();
        System.out.println(any);
    }

}
