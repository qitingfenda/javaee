package com.base.code.java8;

import com.base.code.entity.Father;
import com.base.code.entity.Person;
import org.junit.Test;

import java.util.Optional;

/**
 * @author yhc
 * @create 2020-03-25 16:34
 */
public class OptionalTest {

    /**
     * Optional.of(T t) : 创建一个 Optional 实例 t必须非空
     * Optional.empty() : 创建一个空的 Optional 实例
     * Optional.ofNullable(T t) : t可以为null
     */

    @Test
    public void test03() {
        Person person = new Person();
        person = null;
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        // 如果当前的Optional内部封装的t是非空的，则返回内部的t，如果是空的，则返回orElse()方法中的参数t1
        Person tom = optionalPerson.orElse(new Person("tom", 12));
        System.out.println(tom);
    }

    /**
     * 优化二：使用Optional类
     */
    private String getPersonName2 (Father father) {

        return null;
    }

    /**
     * 优化一
     */
    private String getPersonName1 (Father father) {
        if (father != null) {
            Person person = father.getPerson();
            if (person != null) {
                return person.getName();
            }
        }
        return null;
    }

    private String getPersonName (Father father) {
        return father.getPerson().getName();
    }

    @Test
    public void test02() {
        Father father = new Father();
        father = null;
        Optional<Father> optional = Optional.ofNullable(father);
        System.out.println(optional);
    }

    @Test
    public void test01() {
        Father father = new Father();
//        father = null;
        Optional<Father> optional = Optional.of(father);
        System.out.println(optional);
    }
}
