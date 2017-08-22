package org.lanqiao.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.study.web.model.User;

@SuppressWarnings("serial")
public class AttrListenerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//添加各个域对象的attr
		request.getServletContext().setAttribute("servletContextAttr", "servletContextAttr");
		request.getSession().setAttribute("sessionAttr", "sessionAttr");
		request.setAttribute("requestAttr", "requestAttr");

		//修改各个域对象的attr
		request.getServletContext().setAttribute("servletContextAttr", "servletContextAttr111");
		request.getSession().setAttribute("sessionAttr", "sessionAttr111");
		request.setAttribute("requestAttr", "requestAttr111");

		//移除各个域对象的attr
		request.getServletContext().removeAttribute("servletContextAttr");
		request.getSession().removeAttribute("sessionAttr");
		request.removeAttribute("requestAttr");
		
		request.getSession().setAttribute("user", new User("小蓝", 122));
		request.getSession().removeAttribute("user");
	}
}
