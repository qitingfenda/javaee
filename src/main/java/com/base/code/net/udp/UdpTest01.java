package com.base.code.net.udp;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author yhc
 * @date 2019-12-24 11:16
 */
public class UdpTest01 {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] msg = "udp文本".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(msg, 0, msg.length, address, 8888);
        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }

}
