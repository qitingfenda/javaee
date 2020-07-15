package com.base.code.collection;

/**
 * List接口：存储有序的、可重复的数据。-->"动态"数组
 * ArrayList：作为List接口的主要实现类，线程不安全的，效率高，底层使用Object[]存储
 * LinkedList：对于频繁的插入、删除操作，效率高。底层使用双向链表存储
 * Vector：作为List接口的古来实现类，线程安全的，效率低，底层使用Object[]存储
 * <p>
 * ArrayList的源码分析：
 * - jdk1.7下
 * -- ArrayList list = new ArrayList(); // 底层创建了长度是10的Object[] 数组elementData
 * -- list.add(123); // elementData[0] = new Integer(123);
 * -- ...
 * -- list.add(11); // 如果此次的添加导致底层elementData数组容量不够，则扩容
 * -- 默认情况下，扩容为原来的1.5倍，同时需要将原有数组中的数据复制到新的数组中
 * -- 结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity);
 * <p>
 * - jdk1.8下
 * -- ArrayList list = new ArrayList(); // 底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 * -- list.add(123); // 第一次调用add(); 时，底层才创建了长度10的数组，并将数据123添加到elementData中
 * <p>
 * LinkedList的源码分析：
 * LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 * list.add(123); // 将123封装到Node中，创建了Node对象
 *
 * @author yhc
 * @date 2019-09-16 11:07
 */
public class ListTest {
}
