package com.base.code.net.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL网络编程
 * 1.URL：统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 * http://192.168.2.169:8080/user/addUser.do?username=Tom
 * 协议     主机名      端口号  资源地址          参数列表
 *
 * @author yhc
 * @date 2019-12-24 13:52
 */
public class URLTest01 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://192.168.2.169:8080/user/abc.txt?username=Tom");
            // 获取该URL的协议名
            System.out.println(url.getProtocol());
            // 获取该URL的主机名
            System.out.println(url.getHost());
            // 获取该URL的端口号
            System.out.println(url.getPort());
            // 获取该URL的文件路径
            System.out.println(url.getPath());
            // 获取该URL的文件名
            System.out.println(url.getFile());
            // 获取该URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
