package com.base.lombok;

/**
 * @author yhc
 * @create 2021-03-19 13:54
 */
public class Main {

    public static void main(String[] args) {
        TestModel build = TestModel.builder()
                .age(18)
                .id("123")
                .name("abc")
                .build();
        System.out.println(build);
    }

}
