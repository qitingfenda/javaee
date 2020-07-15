package com.base.code.design;

/**
 * 单例设计模式：
 * <p>
 * 饿汉式：
 * 坏处：对象加载时间过长
 * 好处：饿汉式是线程安全的
 * 懒汉式：
 * 好处：演出对象的创建
 * 坏处：懒汉式是线程不安全的，需要使用synchronized关键字
 *
 * @author yhc
 * @date 2019-06-28 9:02
 */
public class Singleton {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        Order order = Order.getInstance();
    }
}

/**
 * 懒汉式
 */
class Order {

    /**
     * 私有化类的构造器
     */
    private Order() {

    }

    /**
     * 定义该类的静态变量，没有初始化
     */
    private static Order instance;

    /**
     * 提供公共的静态方法，返回该类的对象
     */
    public static Order getInstance() {
        // 锁代码块比锁方法更加高效
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }

}


/**
 * 饿汉式
 */
class Bank {
    /**
     * 私有化类的构造器
     */
    private Bank() {

    }

    /**
     * 定义该类静态变量
     */
    static Bank instance = new Bank();


    /**
     * 提供公共的静态方法，返回该类的对象
     */
    public static Bank getInstance() {
        return instance;
    }
}
