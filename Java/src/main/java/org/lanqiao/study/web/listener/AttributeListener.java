package org.lanqiao.study.web.listener;

import java.text.MessageFormat;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletContextAttributeListener, 
	ServletRequestAttributeListener, HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中添加了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中移除了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中替换了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str + "----------" + event.getSession().getAttribute(event.getName()));
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String str = MessageFormat.format(
				"HttpSession域对象中添加了属性：{0}，属性值是：{1}"
				,srae.getName()
				,srae.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		String str = MessageFormat.format(
				"HttpSession域对象中移除了属性：{0}，属性值是：{1}"
				,srae.getName()
				,srae.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String str = MessageFormat.format(
				"HttpSession域对象中替换了属性：{0}，属性值是：{1}"
				,srae.getName()
				,srae.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中添加了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中移除了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String str = MessageFormat.format(
				"HttpSession域对象中替换了属性：{0}，属性值是：{1}"
				,event.getName()
				,event.getValue());
		System.out.println(str);
	}
	
}
