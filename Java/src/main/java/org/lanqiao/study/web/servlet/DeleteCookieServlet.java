package org.lanqiao.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//删除cookie
		Cookie cookie = new Cookie("info", "");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		System.out.println(req.getServletContext().getAttribute("lifeServletInfo"));
	}
}
