package org.lanqiao.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * 网络多客户端聊天室<br/>
 * 功能1：客户端通过Java NIO连接到服务端，支持多客户端的连接。<br/>
 * 功能2：客户端初次连接时，服务端提示输入昵称，之后发送消息都需要按照规定格式带着昵称发送消息。<br/>
 * 功能3：客户端登录后，发送已经设置好的欢迎信息和在线人数给客户端，并且通知其他客户端该客户端上线。<br/>
 * 功能4：服务器收到已登录客户端输入内容，转发至其他登录客户端。
 * @author 任宏友
 *
 */
public class ChatRoomServer {
	ServerSocketChannel serverSocketChannel;
	Selector selector;
	Charset  charset = Charset.forName("UTF-8");
	int port = 9999;
	
	//初始化数据
	public void init() {
			try {
			serverSocketChannel = ServerSocketChannel.open();
			selector = Selector.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(port));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			watching();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocketChannel.close();
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//向其他客户端发送消息
	public void broadcast(String content, String userName) throws IOException {
		//获取当前所有的selectionKey。注意：selector.selectionKeys()方法返回的不是所有的key
		Set<SelectionKey> keys = selector.keys();
		Iterator<SelectionKey> iterator = keys.iterator();
		while(iterator.hasNext()) {
			SelectionKey selectionKey = iterator.next();
			Channel channel = selectionKey.channel();
			if(channel instanceof SocketChannel) {
				SocketChannel socketChannel = (SocketChannel) channel;
				socketChannel.write(charset.encode(userName + "对大家说" + content));
			}
		}
	}
	
	public void watching() throws IOException {
		System.out.println("服务器启动成功...");
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
				if(selectionKey.isAcceptable()) {
					//客户端接入事件
					SocketChannel channel = serverSocketChannel.accept();
					channel.configureBlocking(false);
					channel.register(selector, SelectionKey.OP_READ);
					//写入欢迎信息
					channel.write(charset.encode("欢迎来到聊天室，请输入姓名"));
//					selectionKey.attach(new UserInfo());
				} else if(selectionKey.isReadable()) {
					//获取客户端channel
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					UserInfo userInfo = (UserInfo) selectionKey.attachment();
					//获取channel内容
					ByteBuffer buffer = ByteBuffer.allocate(128);
					StringBuffer stringBuffer = new StringBuffer();
					int flag = socketChannel.read(buffer);
					while(flag > 0) {
						buffer.flip();
						stringBuffer.append(charset.decode(buffer));
						buffer.clear();
						flag = socketChannel.read(buffer);
					}
					if(null != userInfo && userInfo.init) {
						broadcast(stringBuffer.toString(), userInfo.getName());
					} else {
						//接收用户名
						UserInfo info = new UserInfo();
						info.setName(stringBuffer.toString());
						info.setInit(true);
						selectionKey.attach(info);
						//输出提示信息
						socketChannel.write(charset.encode("您好，" + info.getName() + "，现在你可以和聊天室的小伙伴聊天了。"));
					}
				}
				iterator.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		//创建serverSocketChannel
		try(ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();) {
			serverSocketChannel.configureBlocking(false); //声明非阻塞IO
			//声明一个选择器
			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); //在客户端接入的事件上注册选择器
			ChatRoomServer chatRoomServer = new ChatRoomServer();
			chatRoomServer.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserInfo {
	String name;
	boolean init = false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInit() {
		return init;
	}
	public void setInit(boolean init) {
		this.init = init;
	}
}
