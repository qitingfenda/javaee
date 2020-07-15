package com.base.code.io;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 * 3.需要实现接口Serializable
 * - 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量
 * - serialVersionUID用来表明类的不同版本间的兼容性。简而言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容。
 * - 如果类没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，serialVersionUID可能发生变化。故建议，显示声明。
 * - 除了当前类是可序列化的之外，还必须保证其内部所有属性也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 * - ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author yhc
 * @date 2019-12-06 9:51
 */
public class ObjectInputOutputStreamTest {

    public static void main(String[] args) {
        test02();
    }

    /**
     * 反序列化过程：将磁盘文件中的对象还原为内存中的一个Java对象
     * 使用ObjectInputStream实现
     */
    private static void test02() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\object.dat"));

            String str = (String) ois.readObject();
            System.out.println(str);

            Person person = (Person) ois.readObject();
            System.out.println(person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    private static void test01() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            // 刷新操作
            oos.flush();
            Person person = new Person(20, "123");
            oos.writeObject(person);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
