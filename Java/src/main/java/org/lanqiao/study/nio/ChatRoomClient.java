package org.lanqiao.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ChatRoomClient {
	SocketChannel channel;
	Selector selector;
	int port = 9999;
	String ip = "192.168.0.10";
	
	public void init() {
		try {
			channel = SocketChannel.open(new InetSocketAddress(ip, port));
			channel.configureBlocking(false);
			selector = Selector.open();
			channel.register(selector, SelectionKey.OP_READ);

			//启动Selector线程
			new MySelectorThread(selector).start();
			
			//获取控制台输入
			while(true) {
				@SuppressWarnings("resource") 
				Scanner scanner = new Scanner(System.in);
				String content = scanner.nextLine();
				channel.write(Charset.forName("UTF-8").encode(content));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ChatRoomClient chatRoomClient = new ChatRoomClient();
		chatRoomClient.init();
	}
}

class MySelectorThread extends Thread {
	Selector selector;
	
	public MySelectorThread(Selector selector) {
		this.selector = selector;
	}
	
	@Override
	public void run() {
		try {
			//处理事件
			while(true) {
				int readyChannels = selector.select(); //等待所注册的事件发生
				if(0 == readyChannels) {
					continue;
				}
				//处理事件
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = keys.iterator();
				while(iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if(selectionKey.isReadable()) {
						SocketChannel channel = (SocketChannel) selectionKey.channel();
						ByteBuffer buffer = ByteBuffer.allocate(128);
						StringBuffer stringBuffer = new StringBuffer();
						while(channel.read(buffer) > 0) {
							buffer.flip();
							stringBuffer .append(Charset.forName("UTF-8").decode(buffer));
							buffer.clear();
						}
						System.out.println(stringBuffer.toString());
					}
					iterator.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}