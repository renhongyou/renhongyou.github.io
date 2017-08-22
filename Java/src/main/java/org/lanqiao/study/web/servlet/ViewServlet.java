package org.lanqiao.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//向浏览器写入中文指定编码
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("<h1>--------------ViewServlet---------------</h1>");
		resp.getWriter().println(req.getAttribute("name"));
		
		resp.getWriter().println("<h1>--------------cookie会话信息---------------</h1>");
		//获取会话信息
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				resp.getWriter().println(cookie.getName() + ": " + cookie.getValue());
			}
		}

		resp.getWriter().println("<h1>--------------session会话信息---------------</h1>");
		resp.getWriter().println(req.getSession().getAttribute("info"));
		resp.getWriter().println(req.getSession().getId());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
