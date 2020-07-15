package com.base.code.reflection;

import com.base.code.entity.Person;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 1.直接通过new的方式或反射的方式都可以调用公共的结构，开发中到底使用哪个？
 * - 建议直接使用new的方式。
 * - 什么时候使用反射：需要体现代码动态性的时候
 * <p>
 * 2.反射机制与面对对象中的封装性是不是矛盾的？如何看待两个技术？
 * - 不矛盾。
 * - 封装是为了告诉开发者那些方法不能用那些可以用
 * - 反射是为了让Java的语言变得灵活
 * <p>
 * 关于java.lang.Class 类的理解 （万事万物皆对象）
 * 1.类的加载过程：
 * - 程序经过javac.exe 命令以后，会生成一个或多个字节码文件(.class结尾)。
 * - 接着使用java.exe 命令对某一个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
 * 此过程就称为类的加载过程。加载到内存中的类，我们就称为运行时类，此类运行时，就作为一个Class类的一个实例。
 * <p>
 * 2.Class类的实例对应着一个运行饰类。
 * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
 * <p>
 * 理解Class类并获取Class的实例
 * - 那些类型可以有Class对象？
 * 1.class 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
 * 2.interface：接口
 * 3.[]：数组
 * 4.enum：枚举
 * 5.annotation：注解@interface
 * 6.primitive type：基本数据类型
 * 7.void
 *
 * @author yhc
 * @date 2019-12-25 13:11
 */
public class ReflectionTest01 {

    /**
     * 那些类型可以有Class对象
     */
    @Test
    public void test04() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = int.class;
        Class c7 = void.class;
        Class c8 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(a.getClass() == b.getClass());
    }

    /**
     * 获取Class 类的实例的方式
     */
    @Test
    public void test03() throws Exception {
        // 方式一：调用运行时类的属性：class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 方式二：通过运行时类的对象的getClass()方法
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        // 方式三：调用Class的静态方法：forName(String classPath);
        Class<?> clazz3 = Class.forName("com.base.code.entity.Person");
        System.out.println(clazz3);
        // Class类的实例对应着一个运行时类
        System.out.println(clazz1 == clazz2 && clazz2 == clazz3);
        // 方式四：使用类的加载器：Classloader
        ClassLoader classLoader = ReflectionTest01.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.base.code.entity.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz2 && clazz2 == clazz3 && clazz3 == clazz4);
    }

    /**
     * 反射之后，对Person的操作
     */
    @Test
    public void test02() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Person tom = constructor.newInstance("Tom", 12);
        System.out.println(tom.toString());
        // 通过反射调用对象指定的属性
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 10);
        System.out.println(tom.toString());
        // 通过反射调用对象指定的方法
        Method show = clazz.getDeclaredMethod("show");
        Object result = show.invoke(tom);
        System.out.println(result);
        // 通过反射，可以调用类私有的结构
        constructor = clazz.getDeclaredConstructor(String.class);
        // 设置无障碍
        constructor.setAccessible(true);
        Person jerry = constructor.newInstance("Jerry");
        System.out.println(jerry);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry, "abc");
        System.out.println(jerry);
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        result = showNation.invoke(jerry, "china");
        System.out.println(result);
    }

    /**
     * 反射之前，对Person的操作
     */
    @Test
    public void test01() {
        Person tom = new Person("tom", 12);
        tom.age = 10;
        System.out.println(tom.toString());
        tom.show();
        // 在类的外部，不可以通过Person类的对象调用其内部私有的结构
    }

}
