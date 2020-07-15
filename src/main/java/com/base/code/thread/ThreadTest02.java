package com.base.code.thread;

import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * 同步代码块
 * synchronized(同步监视器){
 * 需要被同步的代码
 * }
 * 操作共享数据的代码，即为需要被同步的代码
 * 同步监视器：俗称-锁 任何一个类的对象，都可以充当锁
 * 要求：多个线程必须共用同一把锁
 * <p>
 * 同步方法
 * 如果操作的共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的
 * 同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 * 非静态的同步方法，同步监视器是this
 * 静态的同步方法，同步监视器是当前类本身
 *
 * @author yhc
 * @date 2019-07-11 14:45
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket, "窗口 1");
        Thread t2 = new Thread(ticket, "窗口 2");
        Thread t3 = new Thread(ticket, "窗口 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable {

    private int number = 1000;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
//            synchronized (this) {
//            }
            method();
        }
    }

    public void method() {
        synchronized (new Date()) {
            if (number > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + "第" + number + "张票");
                number--;
            } else {
                flag = false;
            }
        }
    }

}

