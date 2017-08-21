package org.lanqiao.study.web.protocol;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        try {
            //首先创建一个DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();
            //创建一个InetAddress
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            String str = "hello"; //即将传输的数据
            byte data[] = str.getBytes(); //把传输内容分解成字节
            //创建一个DatagramPacket对象，并指定要将这个数据包发送到网络当中的哪一个地址及其编口号
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 12345);
            //调用socket对象的send方法，发送数据
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
