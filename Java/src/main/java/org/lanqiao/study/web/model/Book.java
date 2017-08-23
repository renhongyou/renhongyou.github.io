package org.lanqiao.study.web.model;

import java.util.Date;

public class Book {
	Integer id;
	String name;
	Float price;
	Date publish;
	
	public Book(Integer id, String name, Float price, Date publish) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.publish = publish;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
}
