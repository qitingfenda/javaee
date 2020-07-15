package com.base.code.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 新增方式二：使用线程池
 * <p>
 * 好处：
 * 提高了响应速度(减少了创建线程的时间)
 * 降低了资源消耗(重复利用线程池中线程，不需要每次都创建)
 * 便于线程管理
 * corePoolSize:核心池的大小
 * maximumPoolSize:最大线程数
 * keepAliveTime:线程没有任务时，最多保持多长时间后会终止
 * <p>
 * Executors:工具类、线程池的工厂类，用于创建并返回不同类型的线程池
 * ->Executors.newCachedThreadPool():创建一个可以根据需要创建新线程的线程池
 * ->Executors.newFixedThreadPool():创建一个可重用固定线程数的线程池
 * ->Executors.newSingleThreadExecutor():创建一个只有一个线程的线程池
 * ->Executors.newScheduledThreadPool(n):创建一个线程池，它可安排在给定延迟后运行命令或定期地执行。
 *
 * @author yhc
 * @date 2019-07-18 15:57
 */
public class ThreadPool {

    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 设置线程池的属性
        ThreadPoolExecutor pool = (ThreadPoolExecutor) service;
        pool.setCorePoolSize(20);
        // 适合时用于Runnable
        service.execute(new MyThread2());
        service.execute(new MyThread3());
        // 适合时用于Callable
//        service.submit();
        // 关闭连接池
        service.shutdown();
    }

}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
