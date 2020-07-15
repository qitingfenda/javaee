package com.base.code.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都会得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以再遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove()
 *
 * @author yhc
 * @date 2019-09-16 10:19
 */
public class IteratorTest {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {

        Collection coll = new ArrayList();

        coll.add("aa");
        coll.add(123);
        coll.add(false);

        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


}
