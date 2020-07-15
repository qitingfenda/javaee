package com.base.code.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhc
 * @date 2019-09-17 9:00
 */
public class ListExer {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list) {
        /**
         * 区分remove方法
         */
        list.remove(2);
        list.remove(new Integer(2));
    }

}
