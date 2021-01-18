package com.base.code.io.test;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author yhc
 * @create 2021-01-04 19:05
 */
@Data
public class DirHandler {
    public static void main(String[] args) {

        String s = "mmm";//

        System.out.println(s);

        DirUtil dirUtil = new DirUtil(s,"C:/Users/七听芬达/IdeaProjects/javaee/src/main/java/com/base/code/io/test");
        dirUtil.create();
    }

}
