package com.base.jvm.jvm08_堆;

/**
 * 测试：-XX:UseTLAB参数是否开启的情况(默认情况是开启的)
 *
 * @author yhc
 * @date 2021/3/30 11:24
 */
public class TLABArgsTest {

    public static void main(String[] args) {
        System.out.println("hello word");

        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
