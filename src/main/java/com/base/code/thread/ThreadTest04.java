package com.base.code.thread;

/**
 * 线程的通信：
 * wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
 * <p>
 * 说明：
 * 1.这三个方法必须使用在同步代码块或同步方法中
 * 2.这三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现InterruptedException(中断)异常
 * 3.这三个方法是定义在Java.lang.Object中
 * <p>
 * sleep()方法 和 wait()方法的异同
 * 同：都可以使得当前的线程进入阻塞状态
 * 异：
 * 1.两个方法声明的位置不同，Thread类中声明sleep(),Object类中声明wait()
 * 2.调用的范围要求不同，sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中
 * 3.sleep()不会自动释放锁，wait()会自动释放锁
 *
 * @author yhc
 * @date 2019-07-12 14:06
 */
public class ThreadTest04 {
    public static void main(String[] args) {
        Communication c = new Communication();
        Thread t1 = new Thread(c, "1");
        Thread t2 = new Thread(c, "2");
        t1.start();
        t2.start();
    }
}


class Communication implements Runnable {
    private int number = 1;
    private boolean flag = true;
    Object obj = new Object();

    @Override
    public void run() {
        while (flag) {
            synchronized (obj) {
                obj.notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number++);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    flag = false;
                }
            }
        }
    }
}

