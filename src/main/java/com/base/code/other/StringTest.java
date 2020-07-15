package com.base.code.other;

/**
 * String:字符串，使用一对""引起来表示。
 * 1.String声明为final的，不可被继承
 * 2.String实现了Serializable接口：表示字符串是支持序列化的。
 * ->实现了Comparable接口：表示String可以比较大小
 * 3.String内部定义了final char[] value用于存储字符串数据
 * 4.String代表不可变的字符序列。简称：不可变性
 * <p>
 * 体现：
 * 1.当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
 * 2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
 * <p>
 * String、StringBuffer、StringBuilder三者的异同？
 * String：不可变的字符序列，底层使用char[]存储
 * StringBuffer：可变的字符序列，线程安全的，效率低，底层使用char[]存储
 * StringBuilder：不可变的字符序列，线程不安全的，效率高，底层使用char[]存储
 *
 * @author yhc
 * @data 2019-07-22 14:13
 */
public class StringTest {
    public static void main(String[] args) {
        method02();
    }

    public static void method03() {
        CCC ccc = new CCC();
        ccc.method(ccc.cc);
        System.out.println(ccc.cc);
    }

    /**
     * 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 只要其中有一个是变量，结果就在堆中
     */
    public static void method02() {
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);


    }

    public static void method01() {
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1 == s2);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("************");

    }


}

class CCC {
    String cc = "abc";

    public void method(String s) {
        s = "aaaaa";
    }
}
