package com.base.code.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author yhc
 * @date 2019-12-19 10:15
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        File srcFile = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
        File destFile = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hell2.txt");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
