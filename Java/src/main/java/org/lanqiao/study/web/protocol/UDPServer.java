package org.lanqiao.study.web.protocol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP服务器实现，面向数据报，不需要稳定的连接（类似短信）
 * @author 任宏友
 *
 */
public class UDPServer {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);
        while (true) {
            byte data[] = new byte[1024];
            //创建一个空的DatagramPacket对象
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //使用receive方法接收客户端所发送的数据，如果客户端没有发送数据，该进程就停滞在此处
            socket.receive(packet);
            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("result ---> " + result);
        }
    }
}
