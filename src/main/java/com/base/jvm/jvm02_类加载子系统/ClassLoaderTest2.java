package com.base.jvm.jvm02_类加载子系统;

/**
 * @author yhc
 * @create 2020-08-04 10:40
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        /*
         * 获取ClassLoader的途径：
         * 方式一：获取当前类的ClassLoader
         * clazz.getClassLoader
         */
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
         * 方式二：获取当前线程上下文的ClassLoader
         * Thread.currentThread.getContextClassLoader()
         */
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        /*
         * 方式三：获取系统的ClassLoader
         * ClassLoader.getSystemClassLoader()
         */
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        /*
         * 方式四：获取调用者的ClassLoader
         * DriverManager.getCallerClassLoader()
         */
    }

}
