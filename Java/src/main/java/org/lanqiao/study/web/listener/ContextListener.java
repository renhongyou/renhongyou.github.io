package org.lanqiao.study.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.http.HttpSessionListener;

public class ContextListener implements ServletContextListener
/*, HttpSessionListener, ServletRequestListener*/  {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext创建...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext销毁...");
	}

}
