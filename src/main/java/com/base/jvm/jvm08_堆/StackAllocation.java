package com.base.jvm.jvm08_堆;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 *
 * @author yhc
 * @create 2021-04-18 15:02
 */
public class StackAllocation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start) + "ms");
        // 为了方便查看堆内存中对象的个数，线程sleep
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    private static void alloc() {
        // 未发生逃逸
        User user = new User();
    }

    static class User {

    }

}
