package com.base.code.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁解决线程安全问题：
 * <p>
 * synchronized 与 Lock的异同
 * 同：二者够可以解决线程安全问题
 * 异：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 * lock需要手动的启动同步，(lock())，同时结束同步也需要手动的实现(unlock())
 *
 * @author yhc
 * @date 2019-07-12 13:26
 */
public class ThreadLockTest {

    public static void main(String[] args) {
        Windows w = new Windows();

        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Windows implements Runnable {
    private int number = 100;

    private boolean flag = true;

    // 1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag) {
            try {
                // 2.调用锁定方法lock()
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + "第" + number + "张票");
                    number--;
                } else {
                    flag = false;
                }
            } finally {
                // 3.调用解锁方法lock.unlock()
                lock.unlock();
            }
        }
    }
}
