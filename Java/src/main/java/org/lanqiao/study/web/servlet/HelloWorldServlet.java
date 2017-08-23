package org.lanqiao.study.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务器端程序
 * @author 任宏友
 *
 */
@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURL().toString());
		System.out.println(req.getRemoteAddr());
		Enumeration<String> headers = req.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName + " : " + req.getHeader(headerName));
		}
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("用户名：<input/>");
		
		//请求转发和重定向
		
		//请求转发 -> url不变，等于1次请求，服务器行为
//		req.getRequestDispatcher("login.html").forward(req, resp);
		
		//重定向 -> url变化，等于发起了2次请求，客户端行为
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
