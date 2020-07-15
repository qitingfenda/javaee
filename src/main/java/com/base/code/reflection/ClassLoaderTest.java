package com.base.code.reflection;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author yhc
 * @date 2019-12-26 9:00
 */
public class ClassLoaderTest {

    /**
     * Properties: 用来读取配置文件
     */
    @Test
    public void test02() throws Exception {
        Properties pros = new Properties();
        // 读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\resources\\test.properties");
//        pros.load(fis);

        // 读取配置文件的方式二：配置文件默认识别为src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("test.properties");
        pros.load(is);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name=" + name);
        System.out.println("password=" + password);
    }

    @Test
    public void test01() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // 调用getParent()：获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        // 调用getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类
        parent = parent.getParent();
        System.out.println(parent);
    }

}
