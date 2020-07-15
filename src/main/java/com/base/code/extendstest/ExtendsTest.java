package com.base.code.extendstest;

/**
 * @author yhc
 * @date 2019-06-26 10:06
 */
public class ExtendsTest {

    public static void main(String[] args) {
        test04();
    }

    public static void test04() {
        Object o = true ? new Integer(1) : new Double(2.0);
        System.out.println(o);
    }

    public static void test03() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println("***********");
        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3 == str4);
    }

    public static void test02() {
        Fu fu = new Fu();

        System.out.println(fu.getClass().getSuperclass());
    }

    public static void test01() {
        Zi z = new Zi();
        System.out.println("*****");
        Zi z2 = new Zi(3);
    }

}
