package com.base.code.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author yhc
 * @date 2019-11-08 9:33
 */
public class PropertiesTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test.properties");
            Properties properties = new Properties();
            properties.load(fis);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println(name + ":" + password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
