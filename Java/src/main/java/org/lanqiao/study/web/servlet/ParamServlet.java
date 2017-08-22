package org.lanqiao.study.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ParamServlet extends HttpServlet {
	@Override
	/**
	 * url访问只能触发get请求，参数随url携带
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决POST中文参数乱码
		request.setCharacterEncoding("UTF-8");
		//get中文参数通过tomcat server.xml中的htp Connector添加URIEncoding = "UTF-8"（tomcat 6以下）
		
		//name=lanqiao&password=123
		
		//获取单一参数
		System.out.println("request.getParameter: " + request.getParameter("name"));
		
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			System.out.println(paramName + ": " + request.getParameter(paramName));
		}
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for (String key : paramMap.keySet()) {
			System.out.println(key + ": " + Arrays.toString(paramMap.get(key)));
		}
		
		//获取多个同名参数值，多用于多选项获取
		System.out.println(Arrays.toString(request.getParameterValues("name")));
		
		//请求转发
		
		//封装数据参数
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("fav", request.getParameterValues("fav"));
		
		request.getRequestDispatcher("view.do").forward(request, response);
		
		//重定向无效
//		response.sendRedirect("view.do");
	}
	@Override
	/**
	 * 可以通过form的method=post提交，参数不随url携带
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
