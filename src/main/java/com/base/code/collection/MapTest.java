package com.base.code.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map接口：双列集合，用来存储一对(key-value)一对的数据
 * <p>
 * HashMap：作为Map的主要实现类，线程不安全的，效率高。可以存储null的key和value
 * - LikedHashMap：作为HashMap的子类，保证在遍历map元素时，可以按照添加的顺序实现遍历。
 * -- 原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 * -- 对于频繁的遍历操作，此类执行效率高于HashMap
 * TreeMap：保证按照添加的顺序对元素进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。底层使用红黑树
 * Hashtable：作为古老的实现类，线程安全的，效率低。不能存储null的key和value
 * - Properties：常用来处理配置文件，key和value都是String类型
 * <p>
 * HashMap的底层：
 * - jdk7及之前：数组+链表
 * - jdk8：数组+链表+红黑树
 * <p>
 * HashMap的底层实现原理(jdk7下)：
 * - HashMap map = new HashMap();
 * - 在实例化以后，底层创建了长度是16的一维数组Entry[] table
 * - map.put(key,value);
 * - 首先调用key所在类的hashCode()方法计算key的哈希值，此哈希值经过某种算法计算以后，得到Entry数组中的存放位置。
 * - 如果此位置上的数据为空，此时的entry添加成功
 * - 如果此位置上的数据不为空(意味着此位置上的数据有一个或多个(链表))，比较key和已存在的一个或多个数据的哈希值
 * - 如果hash值与已存在的数据的哈希值都不相同，此时entry添加成功
 * - 如果和某个或多个数据的哈希值相同，使用equals()比较
 * - 如果equals()不相同则添加成功。
 * - 如果equals()相同使用新的value替换原有的value
 * <p>
 * 在不断添加的过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 * <p>
 * djk8相较于jdk7在底层实现方面的不同：
 * 1.new HashMap():底层没有创建一个长度为16的数组
 * 2.jdk8底层的数组是Node[],而非Entry[]
 * 3.首次调用put()方法时，底层创建长度为16的数组
 * 4.jdk底层结构只有数组+链表。djk8中底层结构：数组+链表+红黑树
 * - 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64 时
 * - 此时此索引位置上的所有数据改为使用红黑树存储。
 * <p>
 * LinkedHashMap的底层实现原理
 * static class Entry<K,V> extends HashMap.Node<K,V> {
 * Entry<K,V> before, after;  // 能够记录添加元素的先后顺序
 * Entry(int hash, K key, V value, Node<K,V> next) {
 * super(hash, key, value, next);
 * }
 * }
 * <p>
 * Map中定义的方法：
 * 添加、删除、修改操作
 * Object put(Object key,Object value)：将指定的key-value添加到(或修改)当前map对象中
 * void putAll(Map m)：将m中的所有key-value对存放到当前map中
 * Object remove(Object key)：移除指定key的key-value对，并返回value
 * void clear()：清空当前map中的所有数据
 * 元素查询的操作：
 * Object get(Object key)：获取指定key对应的value
 * boolean containsKey(Object key)：是否包含指定的key
 * boolean containsValue(Object value)：是否包含指定的value
 * int size()：返回map中key-value对的个数
 * boolean isEmpty()：判断当前map是否为空
 * boolean equals(Object obj)：判断当前map合参数对象obj是否相等
 * 元素操作的方法：
 * Set keySet()：返回所有key构成的Set集合
 * Collection values()：返回所有value构成的Collection集合
 * Set entrySet()：返回所有key-value对构成的Set集合
 *
 * @author yhc
 * @date 2019-09-20 9:47
 */
public class MapTest {

    public static void main(String[] args) {
        test02();
    }

    private static void test02() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key", "value");
    }

    /**
     * 原视图操作的方法
     * Set keySet():返回所有key构成的Set集合
     * Collection values():返回所有value构成的Collection集合
     * Set entrySet(): 返回所有key-value对构成的Set集合
     */
    private static void test01() {
        Map<String, String> map = new HashMap<>(16);
        map.put("AA", "123");
        map.put("BB", "456");
        map.put("CC", "789");
        map.put("DD", "123");

        // 获取所有key
        Set<String> keySet = map.keySet();

        System.out.println(keySet);

        // 获取所有value
        Collection<String> values = map.values();

        System.out.println(values);

        // 获取所有entry
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        System.out.println(entrySet);

        for (Map.Entry<String, String> e : entrySet) {
            System.out.println(e);
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

    }


}
