package org.lanqiao.study.web.protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议服务器，面向连接，发送消息之前，双方需要建立稳定可靠的连接（类似打电话）<br/>
 * 传输层协议：解决双方链路连接上的问题，消息格式没有明确定义
 * @author 任宏友
 *
 */
public class TCPServer {
    //建立ServerSocekt，并设置其端口号
    private ServerSocket serverSocket;
    
    public static final int port = 8899;
    
    public TCPServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器在" + port + "端口上启动成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 处理消息
     */
    public void handleMsg() {
        //建立服务器端的Socket
        Socket socket;
        OutputStream outputStream;
        try {
            System.out.println("等待客户端连接...");
            socket = serverSocket.accept();
            System.out.println("客户端接入成功！");
            
            //接收客户端消息
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
            
            //向客户端传递消息
            outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TCPServer myServer = new TCPServer();
        myServer.handleMsg();
    }
}
