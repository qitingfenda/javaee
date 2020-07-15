package com.base.code.thread;

/**
 * 程序：是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象。
 * <p>
 * 进程：是程序的一次执行过程，或是正在运行的一个程序。是一个动态的过程，有它自身的
 * 产生-运行-消亡的过程--生命周期
 * <p>
 * 线程：进程可进一步细化为线程，是一个程序内部的一条执行路径。
 * ->若一个进程同一时间并行执行多个线程，就是支持多线程的
 * ->线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc)，线程切换的开销小
 * ->一个进程中的多个线程共享相同的内存单元/内存地址空间--他们从同一堆中分配对象，可以
 * 访问相同的变量和对象，这就使得线程间通信更简便、高效、但多个线程操作共享的系统资源
 * 可能就会带来线程安全的隐患。
 * <p>
 * 常用方法：
 * 1.start()：启动当前线程，并调用当前线程的run()
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，放回当前代码的线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield()：释放当前CPU的执行权
 * 7.join()：线程a调用线程b的join()方法，此时线程a进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop()：该方法已过时，当执行此方法时，强制结束当前线程
 * 9.sleep(long millis)：让当前线程"睡眠"指定的毫秒数，在指定的毫秒时间内，当前线程是阻塞状态
 * 10isAlive():判断当前线程是否存活
 * <p>
 * 线程的优先级：
 * MAX_PRIORITY：10
 * NORM_PRIORITY：5 -->默认
 * MIN_PRIORITY：1
 * 设置和获取当前线程的优先级
 * getPriority():获取当前线程的优先级
 * setPriority(int newPriority):设置当前线程的优先级
 * <p>
 * 线程的生命周期
 * 新建：当一个Thread类或其它子类的对象被声明并创建时，新生的线程对象处于新建状态
 * 就绪：处于新建状态的线程被start()后，将进入线程队列等待CPU分配时间片，此时
 * 他已经具备了运行的条件，只是没分配到CPU的资源
 * 运行：当就绪的线程被调度并获取到CPU资源时，便进入运行状态，run()方法定义了线程的操作和功能
 * 阻塞：在某种特殊情况下，被人为挂起或执行输入输出操作时，让CPU临时终止自己的执行，进入阻塞状态
 * 死亡：线程完成了它的全部工作或线程被提前强制性的终止或出现异常导致结束
 *
 * @author yhc
 * @date 2019-07-10 10:49
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + Thread.currentThread().getName());
            }
            if (i == 20) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == 40) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(t.isAlive());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + Thread.currentThread().getName());
            }
//            if (i % 20 == 0) {
//                yield();
//            }
        }
    }
}

