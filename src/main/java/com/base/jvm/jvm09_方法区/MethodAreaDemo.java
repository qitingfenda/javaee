package com.base.jvm.jvm09_方法区;

/**
 * 测试设置方法区大小参数的默认值
 * jdk7 -XX:PermSize,-XX:MaxPermSize
 * jdk8 -XX:MetaspaceSize,-XX:MaxMetaspaceSize
 *
 * @author yhc
 * @create 2021-05-17 9:24
 */
public class MethodAreaDemo {

    public static void main(String[] args) {
        System.out.println("start...");

        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }

}
