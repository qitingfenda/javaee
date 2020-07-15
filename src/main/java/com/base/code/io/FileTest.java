package com.base.code.io;

import java.io.File;

/**
 * File类的使用
 * <p>
 * 1.File类的一个队形，代表一个文件或一个文件目录(俗称：文件夹)
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件夹目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"target"。
 *
 * @author yhc
 * @date 2019-11-14 14:39
 */
public class FileTest {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 1.如何创建File类的实例
     * File(String filePath)
     * File(String parentPath,String childPath)
     * File(File parentPath,String childPath)
     * <p>
     * 2.
     * 相对路径：相较于某个路径下，指明的路径
     * 绝对路径：包含盘符在内的文件或文件目录的路径
     * <p>
     * 3.路径分隔符
     * windows:\
     * unix:/
     * <p>
     * String getAbsolutePath()：获取绝对路径
     * String getPath()：获取路径
     * String getParent()：获取上层文件目录路径。若无，返回null
     * long length()：获取文长度(即：字节数)。布恩那个获取目录的长度。
     * long lastModified()：获取最后一次的修改时间，毫秒值
     * <p>
     * String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
     * File[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组
     * <p>
     * boolean renameTo(File dest)：把文件重命名为指定的文件路径
     * <p>
     * boolean isDirectory()：判断是否是文件目录
     * boolean isFile()：判断是否是文件
     * boolean exists()：判断是否存在
     * boolean canRead()：判断是否可读
     * boolean canWrite()：判断是否可写
     * boolean isHidden()：判断是否隐藏
     * <p>
     * boolean createNewFile()：创建文件，若文件存在，则不常见，返回false。
     * boolean mkdir()：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层不存在，返回false
     * boolean mkdirs()：创建文件目录。如果上层文件目录不存在，一并创建
     * <p>
     * boolean delete()：删除文件或者文件夹。注意事项：Java中的删除不走回收站
     * <p>
     * 一、流的分类：
     * 1.操作数据单位：节点流、字符流
     * 2.数据的流向：输入流、输出流
     * 3.流的角色：节点流、处理流
     * <p>
     * 二、I0流体系
     * 分类         字节输入流             字节输出流              字符输入流          字符输出流
     * 抽象基类     InputStream           OutputStream           Reader             Writer
     * 访问文件     FileInputStream       FileOutputStream       FileReader         FileWriter
     * 访问数组     ByteArrayInputStream  ByteArrayOutputStream  CharArrayReader    CharArrayWriter
     * 访问管道     PipedInputStream      PipedOutputStream      PipedReader        PipedWriter
     * 访问字符串                                                StringReader       StringWriter
     * 缓冲流       BufferedInputStream   BufferedOutputStream   BufferedReader     BufferedWriter
     * 转换流                                                    InputStreamReader  OutputStreamWriter
     * 对象流       ObjectInputStream     ObjectOutputStream
     * FilterInputStream     FilterOutputStream     FilterReader       FilterWriter
     * 打印流                             PrintStream                               PrintWriter
     * 推回输入流   PushbackInputStream                          PushbackReader
     * 特殊流      DataInputStream       DataOutputStream
     */
    private static void test01() {

        File file = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt");
        File file1 = new File("C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hell.txt");

        boolean exists = file.exists();

        System.out.println(exists);

        String path = file.getPath();

        System.out.println(path);

        File absoluteFile = file.getAbsoluteFile();

        System.out.println(absoluteFile);

        boolean flag = file.renameTo(file1);

        System.out.println(flag);
    }

}
