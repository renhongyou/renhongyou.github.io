package org.lanqiao.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		request.setAttribute("fav", "测试值");
		//cookie实现会话跟踪
		//写cookie
		Cookie cookie = new Cookie("info", name);
		//cookie有效时间：0代表删除cookie，-1代表永久有效，直到浏览器关闭，或者以秒为单位的int
		cookie.setMaxAge(-1);
//		response.setCharacterEncoding("utf-8");
		response.addCookie(cookie);
		
		//session会话跟踪
		HttpSession session = request.getSession();
		session.setAttribute("info", name); //内容不限定，可以是Object
		request.getRequestDispatcher("view.do").forward(request, response);
//		response.sendRedirect("view.do");
	}
}
