package org.lanqiao.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
/**
 * 一个Servlet在容器中之被初始化一次
 * @author 任宏友
 *
 */
public class LifecycleServlet extends HttpServlet {
	ServletConfig config;
	
	public LifecycleServlet() {
		System.out.println("LifecycleServlet构造方法执行...");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("LifecycleServlet的service执行");
		super.service(arg0, arg1);
	}

	@Override
	public void destroy() {
		System.out.println("LifecycleServlet的destory执行");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifecycleServlet的init执行");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("执行doGet");
		System.out.println(config.getServletContext().getInitParameter("encoding"));
		req.getServletContext().setAttribute("lifeServletInfo", "hello, i am life");
//		System.out.println(config.getInitParameter("initInfo"));
		System.out.println(getInitParameter("initInfo") + "父类方法获得");
		super.doGet(req, resp);
	}
	
}
