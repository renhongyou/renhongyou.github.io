package org.lanqiao.study.web.protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * TCP协议客户端
 * @author 任宏友
 *
 */
public class TCPClient {
	public static final String IP = "127.0.0.1";
	public static final int port = 8899;
    private Socket socket;
	
    public TCPClient() {
		try {
		    socket = new Socket(IP, port);
		    System.out.println("客户端启动成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
    public void handleMsg() {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            //向服务器发送消息
            outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("你好服务器！" + "\n");
            bufferedWriter.flush();
            
            //接收服务器消息
            inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TCPClient myClient = new TCPClient();
        myClient.handleMsg();
    }
}
