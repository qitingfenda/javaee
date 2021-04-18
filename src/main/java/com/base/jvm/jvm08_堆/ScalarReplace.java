package com.base.jvm.jvm08_堆;

/**
 * 标量替换
 * <p>
 * -Xmx1G -Xms1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:-EliminateAllocations
 *
 * @author yhc
 * @create 2021-04-18 15:44
 */
public class ScalarReplace {

    public static class User {
        public int id;
        public String name;
    }

    public static void alloc() {
        // 未发生逃逸
        User u = new User();
        u.id = 5;
        u.name = "yhc";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start) + "ms");

    }

}
