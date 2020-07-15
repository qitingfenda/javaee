package com.base.code.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 * 1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 * <p>
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 * <p>
 * 三、通信要素一：IP和端口号
 * <p>
 * 1.IP：唯一的标识 Internet 上的计算机（通信实体类）
 * 2.在Java中使用 InetAddress 类代表IP
 * 3.IP分类：IPv4 和 IPv6;万维网和局域网
 * 4.域名
 * 5.本地回路地址：127.0.0.1 localhost
 * 6.如何实例化InetAddress:两个方法 getByName(String host); getLocalHost();
 * 两个常用方法：getHostName() / getHostAddress()
 * 7.端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：被规定未一个 16 位的整数 0~65535
 * 8.端口号与IP地址的组合得出一个网络套接字：Socket
 * <p>
 * TCP协议：
 * - 使用TCP协议前，需先建立TCP连接，形成传输数据通道
 * - 传输前，采用“三次握手”方式，点对点通信，是可靠的
 * - TCP协议进行通信的两个应用进程：客户端、服务端
 * - 在连接中可进行大数据量的传输
 * - 传输完毕，需释放已建立的连接，效率低
 * <p>
 * UDP协议：
 * - 将数据、源、目的封装成数据包，不需要建立连接
 * - 每个数据包的大小限制在64K内
 * - 发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
 * - 可以广播发送
 * - 发送数据结束时无需释放资源，开销小，速度块
 *
 * @author yhc
 * @date 2019-12-19 10:38
 */
public class InteAddressTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            System.out.println(address);
            // 获取本地IP
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
