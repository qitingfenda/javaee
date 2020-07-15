package com.base.code.collection;

import java.util.*;

/**
 * Set接口：存储无序的、不可重复的数据
 * HashSet：作为Set接口的主要实现类，线程不安全的，可以存储null值
 * |-- LinkedHashSet：作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 * TreeSet：可以按照添加对象的指定属性，进行排序
 * <p>
 * 1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法
 * <p>
 * 2.要求：
 * - 向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 * - 重写的hashCode和equals()尽可能保持一致性(相等的对象必须具有相等的散列码)
 * <p>
 * 重写两个方法的小技巧：对象中作用的equals()方法比较的Field，都应该用来计算hashCode
 *
 * @author yhc
 * @date 2019-09-17 9:07
 */
public class SetTest {

    public static void main(String[] args) {
        test04();
    }

    /**
     * Set:存储无序的、不可重复的数据
     * <p>
     * 1.无序性：不等于随机性。以HashSet为例，存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
     * <p>
     * 2.不可重复性：保证添加的元素按照equals()判断时，不能返回true,即.相同的元素只能添加一个
     * <p>
     * 添加元素的过程：以HashSet为例
     * - 我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     * - 此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即：索引位置），判断
     * - 数组此位置上是否已经有元素，如果此位置上没有其他元素，则元素a添加成功
     * - 如果此位置上有其它元素b，则比较元素a于元素b的hash值，
     * - 如果hash值不相同，则元素a添加成功
     * - 如果hash值相同，进而需要调用元素a所在类的equals()方法
     * - equals()返回true，元素a添加失败
     * - equals()返回false，元素a添加成功
     * - 对于添加成功的情况而言，元素a与已经存在指定索引位置上数据以链表的方式存储
     * - jdk7：元素a放到数组中，指向原来的元素
     * - jdk8：原来的元素在数组中，指向元素a
     * <p>
     * HashSet底层：数组+链表的结构
     */
    private static void test01() {

        Set set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("aa");
        set.add("AA");
        set.add(false);
        set.add(true);
        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "12"));

        for (Object e : set) {
            System.out.println(e);
        }

    }

    /**
     * LinkedHashSet的使用：
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据全一个数据和后一个数据
     * 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    private static void test02() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("aa");
        set.add("AA");
        set.add(false);
        set.add(true);
        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "12"));

        for (Object e : set) {
            System.out.println(e);
        }
    }

    /**
     * 1.向TreeSet中添加的数据，要求是像同类的对象
     * 2.两种排序方式：自然排（实现Comparable接口），定制排序（Comparator）
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()
     */
    private static void test03() {
        Set set = new TreeSet();
        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "88"));
        set.add(new Person("bb", "12"));
        set.add(new Person("cc", "12"));
        set.add(new Person("dd", "12"));
        set.add(new Person("ee", "12"));

        for (Object e : set) {
            System.out.println(e);
        }

    }

    private static void test04() {
        Comparator<Person> comparator = (o1, o2) -> o1.name.compareTo(o2.name) != 0 ? o1.name.compareTo(o2.name) : o1.age.compareTo(o2.age);

        Set set = new TreeSet(comparator);

        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "12"));
        set.add(new Person("aa", "88"));
        set.add(new Person("bb", "12"));
        set.add(new Person("cc", "12"));
        set.add(new Person("dd", "12"));
        set.add(new Person("ee", "12"));

        for (Object e : set) {
            System.out.println(e);
        }
    }

    static class Person implements Comparable {
        private String name;
        private String age;

        public Person() {
        }

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(age, person.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Person) {
                Person person = (Person) o;
                return this.name.compareTo(person.name) != 0 ? this.name.compareTo(person.name) : this.age.compareTo(person.age);
            }
            throw new RuntimeException("类型错误");
        }
    }

}
