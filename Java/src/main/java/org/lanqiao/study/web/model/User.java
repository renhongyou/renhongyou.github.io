package org.lanqiao.study.web.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	String name;
	Integer age;
	
	public User() {
		
	}
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(this + " 被添加到Session中");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(this + " 被Session移除");
	}
}
