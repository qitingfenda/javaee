package com.base.jvm.jvm02_类加载子系统;

/**
 * @author yhc
 * @create 2020-08-04 9:32
 */
public class ClassInitTest {
    // 任何一个类声明以后，内部至少存在一个构造器

    private static int num = 5;

    static {
        num = 9;
        number = 20;
        System.out.println(num);
//        System.out.println(number);非法提前引用
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }

}
