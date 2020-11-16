package com.base.jvm.jvm08_堆;

/**
 * -Xms600m -Xmx600m
 * -NewRatio：设置新生代与老年代的比例，默认是2
 * -XX:SurvivorRatio：设置新生代中Eden区与Survivor区的比例。默认值是8
 * -XX:-UseAdaptiveSizePolicy：关闭自适应的内存分配策略（暂时用不到）
 * -Xmn：设置新生代的空间的大小（一般不设置）
 *
 *
 * @author yhc
 * @create 2020-09-29 15:10
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
