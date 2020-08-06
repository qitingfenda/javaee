package com.base.jvm.jvm02_类加载子系统;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * @author yhc
 * @create 2020-08-04 10:40
 */
public class ClassLoaderTest1 {

    public static void main(String[] args) {
        System.out.println("*******************启动类加载器**********************");
        // 获取BootstrapClassLoader能够加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
        // 从上面的路径中随意选择一个类，看看他的类加载器是什么(引导类加载器)
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);// null
        System.out.println("*******************扩展类加载器**********************");
        // 获取扩展类加载器能加载的类(部分类)
        String property = System.getProperty("java.ext.dirs");
        for (String path : property.split(";")) {
            System.out.println(path);
        }
        // 从上面的路径中随意选择一个类，看看他的类加载器是什么(扩展类加载器)
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);// sun.misc.Launcher$ExtClassLoader@2f2c9b19
    }

}
