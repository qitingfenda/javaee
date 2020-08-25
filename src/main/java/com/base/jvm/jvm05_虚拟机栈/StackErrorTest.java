package com.base.jvm.jvm05_虚拟机栈;

/**
 * @author yhc
 * @create 2020-08-18 15:57
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count++);
        main(new String[]{});
    }
}
