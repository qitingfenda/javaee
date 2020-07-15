package com.base.code.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK5.0新增的创建线程的方式
 * 新增方式一：实现Callable接口
 * 与使用Runnable相比，Callable功能更强大些
 * 相比run()方法，可以有返回值
 * 方法可以抛出异常
 * 支持泛型的返回值
 * 需要借助FutureTask类，比如获取返回结果
 *
 * @author yhc
 * @date 2019-07-12 15:28
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        // 3.创建Callable接口实现类的对象
        MyCallable callable = new MyCallable();
        // 4.将此Callable接口实现类的对象，作为参数，传到FutureTask构造器中，创建FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        // 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，调用start()方法，启动线程
        new Thread(futureTask).start();
        try {
            // 6.获取call()方法的返回值
            // get方法返回值，即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Integer sum = futureTask.get();
            System.out.println("总合为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        System.out.println("d");
    }
}

// 1.创建一个实现Callable接口的实现类
class MyCallable implements Callable<Integer> {
    // 2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


