package com.base.code.other;

/**
 * 内部类
 * 1.Java中允许将一个类A声明在一个类B中，则类A就是内部类，类B称为外部类。
 * 2.内部类的分类：成员内部类  VS  局部内部类(方法内、代码块内、构造器内)
 * 3.成员内部类：
 * > 一方面，作为外部类的成员
 * >> 能调用外部类的结构
 * >> 可以被static修饰
 * >> 可以被4中不同的权限修饰
 * > 另一方面，作为一个类
 * >> 类内可以定义属性、方法、构造器等
 * >> 可以被final修饰，表示此类不能被继承。不使用，则可以被继承。
 * >> 可以被abstract修饰
 * 4.关注如下3个问题
 * > 如何实例化成员内部类的对象
 * > 如何在成员内部类中区分调用外部类的结构
 * > 开发中局部内部类的使用
 *
 * @author yhc
 * @date 2019-07-02 10:50
 */
public class InnerClassTest {
    public static void main(String[] args) {
        // 创建静态的成员内部类
        A.DD dd = new A.DD();
        dd.sing();
        System.out.println("***************");
        // 创建非静态的成员内部类
        A a = new A();
        A.EE ee = a.new EE();
        ee.sing();
    }
}

class A {

    String attribute;

    /**
     * 返回一个实现了Comparable接口的类的对象
     */
    public Comparable getComparable() {
        /**
         * 方式一：
         * 创建一个实现了Comparable接口的类
         */
//        class MyComparable implements Comparable {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();

        /**
         * 方式二
         */
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    public void eat() {
        System.out.println("eat");
    }

    /**
     * 静态成员内部类
     */
    static class DD {
        String age;

        public DD() {
        }

        public void sing() {
            System.out.println("dddd");
        }
    }

    /**
     * 非静态成员内部类
     */
    class EE {
        String name;

        public EE() {
        }

        public void sing() {
            eat();
            A.this.eat();
            System.out.println("eeee");
        }

    }

    public void method() {
        /**
         * 局部内部类
         */
        class AA {
        }
    }

    {
        /**
         * 局部内部列
         */
        class BB {
        }
    }

    public A() {
        /**
         * 局部内部类
         */
        class CC {
        }
    }
}

