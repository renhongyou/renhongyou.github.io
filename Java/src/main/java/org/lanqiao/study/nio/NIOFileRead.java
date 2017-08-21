package org.lanqiao.study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 利用channel和buffer读取文件内容。
 * @author 任宏友
 *
 */
public class NIOFileRead {
	public static void main(String[] args) {
		//创建channel对象
		//自带资源管理的try/catch
		try(FileChannel channel = FileChannel.open(Paths.get("f:/test.txt"), StandardOpenOption.READ);) {
			//读取chennel内容
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			int flag = channel.read(buffer); //position / limit / capacity
			while(-1 != flag) {
				//处理buffer
				buffer.flip(); //切换写模式到读模式，limit = position then position = 0
//				CharBuffer charBuffer = buffer.asCharBuffer();
				Charset charset = Charset.forName("UTF-8"); //声明编码格式
				CharBuffer charbuffer = charset.decode(buffer); //把ByteBuffer编码成字符
				while(charbuffer.hasRemaining()) {
					System.out.print(charbuffer.get());
				}
				buffer.clear();
				flag = channel.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//异常处理
	}
}
