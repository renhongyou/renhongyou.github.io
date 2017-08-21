package org.lanqiao.study.web.protocol;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTP {
    public static void main(String[] args) {
        //jar包
        
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        
        //创建Http请求对象
        HttpPost httpPost = new HttpPost("http://www.baidu.com");
        
        //处理响应对象
        try {
            //获取响应消息
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
