package com.base.code.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhc
 * @date 2019-11-12 14:59
 */
public class Order<T> {
    String orderName;
    String orderId;

    // 类的内部接口可以使用类的泛型

    T orderT;

    public Order() {
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName, String orderid, T orderT) {
        this.orderName = orderName;
        this.orderId = orderid;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderid='" + orderId + '\'' +
                ", orderT=" + orderT +
                '}';
    }

    public static void showT() {
        // 静态方法中不能使用类的泛型
//        System.out.println(orderT);
    }

    /**
     * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
     * 泛型方法所属的类是不是泛型类都没有关系
     * 泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定的。
     */
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);

        }
        return list;
    }

}
