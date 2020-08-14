package com.base.jvm.jvm05_虚拟机栈;

/**
 * @author yhc
 * @create 2020-08-10 11:23
 */
public class StackTest {

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.methodA();
    }

    private void methodA() {
        int i = 10;
        int j = 20;
        methodB();
    }

    private void methodB() {
        int m = 30;
        int k = 40;
    }

}
