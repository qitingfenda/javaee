package com.base.code.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的使用
 * 1.jdk1.5新增的特性
 * <p>
 * 2.在集合中使用泛型：
 * 总结：
 * ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * ② 在实例化集合类时，可以指明具体的泛型类型
 * ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型
 * 比如：add(E e)--->实例化以后 add(Integer e)
 * ④ 注意点：泛型的类型必须是引用数据类型。
 * ⑤ 如果实例化时，没有指明泛型的类型。默认类型为Object类型
 * <p>
 * 3.自定义泛型结构：泛型类、泛型接口、泛型方法
 * <p>
 * 泛型在继承方面的体现
 * 类A是类B的父类，但是List<A> 和 List<B>二者不具备子父类关系，二者是并列关系
 * <p>
 * 通配符的使用
 * 通配符：?
 * 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
 * 通配符指定上限
 * extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
 * <? extends Number>：只允许泛型为Number及Number子类的引用调用
 * <? extends Comparable>：只允许泛型为实现Comparable接口实现类的引用调用
 * 通配符指定下限
 * super：使用时指定的类型不能小于操作的类，即>=
 * <? super Number>：只允许泛型为Number及Number父类的引用调用
 *
 * @author yhc
 * @date 2019-11-12 13:48
 */
public class GenericTest {

    public static void main(String[] args) {
        test10();
    }

    private static void test10() {
        List<? extends Order> list1 = null;
        List<? super Order> list2 = null;

        List<SubOrder> list3 = null;
        List<Order> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;
    }

    private static void test09() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        // 添加：对于List<?>就不能向其内部添加数据。
        // 除了添加null之外
//        list.add("aa");
        list.add(null);

        // 获取：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }

    private static void test08() {

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时的list1和list2的类型不具有子父类的关系
//        list1 = list2;

    }

    private static void test07() {
        Order<Integer> order = new Order<>();
        String[] arr = new String[10];
        List<String> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }

    private static void test06() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

        // 泛型不同的引用不能相互复制
//        list1 = list2;
    }

    private static void test05() {
        SubOrder1<String> subOrder = new SubOrder1<>();
        subOrder.setOrderT("abc");
    }

    private static void test04() {
        SubOrder subOrder = new SubOrder();
        // 由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderT(123);
    }

    private static void test03() {
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        // 要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        Order<String> order1 = new Order<>();
//        order1.setOrderT(123);
        order1.setOrderT("abc");
    }

    private static void test02() {
        // 集合使用泛型之后的情况：

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);

        // 编译时，就会进行类型检查，保证数据的安全
//        list.add("abc");
        for (Integer score : list) {
            // 避免了强转操作
            int stuScore = score;
            System.out.println(stuScore);
        }
    }

    private static void test01() {
        // 集合使用泛型之前的情况：

        ArrayList list = new ArrayList();
        // 需求：存放学生的成绩
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        // 问题一：类型不安全
//        list.add("abc");

        for (Object score : list) {
            // 问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

}
