package com.base.code.reflection;

import com.base.code.entity.Person;
import org.junit.Test;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author yhc
 * @date 2019-12-26 9:31
 */
public class NewInstanceTest {

    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /**
         * newInstance(): 调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器
         *
         * 要想此方法正常的创建运行时类的对象，要求：
         * 1.运行时类必须提供空参的构造器
         * 2.空参的构造器的访问权限为public
         *
         * 在javabean中要求提供一个public的空参构造器。原因：
         * 1.便于通过反射，创建运行时类的对象
         * 2.便于子类继承此运行时类，默认调用super()时，保证父类有此构造器
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

}
