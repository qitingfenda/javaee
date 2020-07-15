package com.base.code.entity;

import lombok.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhc
 * @date 2019-12-25 13:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
    private String name;
    public int age;

    public void show() {
        System.out.println("my name is " + name);
    }

    public Person(String name) {
        this.name = name;
    }

    @Test
    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    private String say(String a, String b) throws Exception {
        return "hello";
    }

    public String getName() {
        return name;
    }

    public static String applyHello(String str) {
        return str + "hello";
    }

    public static List<Person> getPersonData() {
        List<Person> result = new ArrayList<>(10);
        result.add(new Person("tom",22));
        result.add(new Person("cry",545));
        result.add(new Person("yhc",22));
        result.add(new Person("jerry",2));
        result.add(new Person("aaa",11));
        result.add(new Person("zzzzzzzzz",4));
        result.add(new Person("g",18));
        result.add(new Person("hello",20));
        result.add(new Person("world",19));
        result.add(new Person("yhc",22));
        return result;
    }

}
