package org.lanqiao.study.nio;

import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.Channels;
//import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import java.nio.file.StandardOpenOption;

/**
 * 利用NIO完成文件复制。
 * @author 任宏友
 *
 */
public class NIOFileCopy {
	public static void main(String[] args) {
//		//创建读取文件通道
//		//创建写入文件通道
//		try(FileChannel srcChannel = FileChannel.open(Paths.get("f:/test.txt"), StandardOpenOption.READ);) {
//			FileChannel targetChannel = FileChannel.open(
//					Paths.get("f:/test1.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
//			
////			FileChannel channel = Files.newByteChannel(path, options); //通过Files工具类创建channel
////			Channels.newChannel(inputstream); //通过Channels工具类，创建channel对象
//			
//			//读取到buffer
//			ByteBuffer buffer = ByteBuffer.allocate(1024);
//			int flag = srcChannel.read(buffer);
//			while(-1 != flag) {
//				buffer.flip(); //切换写模式到读模式 -> limit = position -> position = 0
//				//写入到目标通道
//				int result = targetChannel.write(buffer);
//				System.out.println(result);
//				buffer.clear();
//				flag = srcChannel.read(buffer);
//			}
//			
		try {
			Files.copy(Paths.get("f:/test.txt"), Paths.get("f:/test1.txt"), 
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
