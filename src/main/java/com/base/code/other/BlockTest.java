package com.base.code.other;

/**
 * 类的成员：代码块(初始化块)
 * <p>
 * 1.代码块的作用，用来初始化类、对象
 * 2.代码块如果有修饰的话，只能使用static
 * 3.分类：静态代码块   VS   非静态代码块
 * 静态代码块：随着类的加载而执行（执行一次）
 * 非静态代码块：随着类的创建而执行（每次创建对象都会执行）
 * <p>
 * 如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * <p>
 * 静态代码块的执行要优先于非静态代码块的执行
 *
 * @author yhc
 * @date 2019-06-28 13:57
 */
public class BlockTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
    }
}

class Person {
    String name;
    int age;
    static String desc = "message...";

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // static代码块
    static {
        System.out.println("hello static block");
    }

    // 非static代码块
    {
        System.out.println("hello block");
    }

    public void method() {
        System.out.println("method...");
    }

}
