package com.base.jvm.jvm08_堆;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 MinorGC、MajorGC、FullGC
 *
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 *
 * @author yhc
 * @date 2021/3/30 10:20
 */
public class GCTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello word";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("遍历次数：" + i);
        }
    }

}
