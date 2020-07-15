package com.base.code.net.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 1.例子1：客户端发送信息给服务器，服务器将数据显示在控制台上
 *
 * @author yhc
 * @date 2019-12-20 14:14
 */
public class TcpTest01 {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 创建Socket对象，指明服务器端的ip和端口号
            InetAddress address = InetAddress.getByName("192.168.2.169");
            socket = new Socket(address, 8899);
            // 获取输出流，用于输出数据
            os = socket.getOutputStream();
            // 写出
            os.write("你好，world".getBytes());
            System.out.println("send over...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 服务端
     */
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            while (true) {
                // 调用accept()表示接收来自于客户端的socket
                socket = serverSocket.accept();
                // 获取输入流
                is = socket.getInputStream();
                // 读取输入流中的数据
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[5];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                String senderAddress = socket.getInetAddress().getHostAddress();
                System.out.println(senderAddress + "：" + baos.toString());

                // 可能会乱码
//                byte[] buffer = new byte[1024];
//                int len;
//                while ((len = is.read(buffer)) != -1) {
//                    String msg = new String(buffer, 0, len);
//                    System.out.println(msg);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
