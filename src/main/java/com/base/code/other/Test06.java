package com.base.code.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yhc
 * @create 2022-08-08 9:12
 */
public class Test06 {
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        String item = "a";
        list.remove(item);
//        int moveIndex = list.indexOf("e") + 1;
        int moveIndex = list.indexOf("c");
        list.add(moveIndex, item);
        list.forEach(System.out::print);
    }

}
