package org.lanqiao.study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 利用NIO替换大文件内容。
 * @author 任宏友
 *
 */
public class NIOFileContentReplace {
	public static void main(String[] args) {
		//创建channel对象
		try(FileChannel channel = FileChannel.open(Paths.get("f:/test.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE);) {
			//读取文件内容，读取buffer
			ByteBuffer buffer = ByteBuffer.allocate(4);
			int flag = channel.read(buffer);
			while(-1 != flag) {
				buffer.flip();
				CharBuffer charBuffer = Charset.forName("UTF-8").decode(buffer);
				while(charBuffer.hasRemaining()) {
					if('o' == charBuffer.get()) {
						//替换内容
						String content = new String(buffer.array(), "UTF-8");
						String newContent = content.replace('o', 'q');
						//重置channel的position，由于channel.read会影响这个值
						channel.position(channel.position() - buffer.limit());
						//写回文件
						channel.write(ByteBuffer.wrap(newContent.getBytes()));
					}
				}
				buffer.clear();
				flag = channel.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
