package com.base.code.reflection;

import com.base.code.entity.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author yhc
 * @date 2019-12-26 13:23
 */
public class ReflectionTest03 {

    @Test
    public void constructorTest() throws Exception {
        Class<Person> clazz = Person.class;
        /*
        getDeclaredConstructor():
        参数：指明该构造器的参数列表
         */
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        // 保证当前构造器是可访问的
        constructor.setAccessible(true);
        /*
        newInstance():
        参数：即为构造器的参数
         */
        Person person = constructor.newInstance("Tom", 19);
        System.out.println(person);
    }

    @Test
    public void method() throws Exception {
        Class<Person> clazz = Person.class;
        // 获取实例
        Person person = clazz.newInstance();
        /*
        获取指定的某个方法
        getDeclaredMethod():
        参数1：指明获取的方法的名称
        参数2：指明获取的方法的形参列表
         */
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        // 保证当前方法是可访问的
        showNation.setAccessible(true);
        /*
        invoke()：
        参数1：方法的调用者
        参数2：方法的形参列表
        该方法的返回值即为实例调用该方法的返回值
        如果此方法没有返回值，则invoke方法返回值为null
         */
        Object result = showNation.invoke(person, "china");
        System.out.println(result);
    }


    @Test
    public void fieldTest() throws Exception {
        Class<Person> clazz = Person.class;
        // 获取实例
        Person person = clazz.newInstance();
        // getField获取指定的属性，该方法无法获取私有属性
        Field age = clazz.getField("age");
        /*
        设置当前属性的值
        set():
        参数1：指明设置哪个对象的属性
        参数2：将属性值设置为多少
         */
        age.set(person, 18);
        System.out.println(person);
        // 开发中一般使用getDeclaredField(String name)获取属性
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性是可访问的
        name.setAccessible(true);
        name.set(person, "Tom");
        System.out.println(person);
    }

}
