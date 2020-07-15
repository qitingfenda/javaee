package com.base.code.net.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yhc
 * @date 2019-12-20 15:37
 */
public class TcpTest02 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 8888);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\七听芬达\\Pictures\\head.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\Users\\七听芬达\\Pictures\\head2.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}
