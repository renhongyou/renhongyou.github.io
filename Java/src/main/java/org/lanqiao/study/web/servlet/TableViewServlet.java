package org.lanqiao.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.study.web.model.Book;

@SuppressWarnings("serial")
public class TableViewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "Java编程思想", 88f, new Date()));
		books.add(new Book(2, "JavaWeb开发", 128f, new Date()));
		books.add(new Book(3, "数据库开发", 99f, new Date()));

		PrintWriter writer = resp.getWriter();
		writer.println("<table border=1>");
		writer.println("<td>");
		writer.println("标识");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("名称");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("价格");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("日期");
		writer.println("</td>");
		for (Book book : books) {
			//输出行信息
			writer.println("<tr>");
			writer.println("<td>");
			writer.println(book.getId());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(book.getName());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(book.getPrice());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(book.getPublish());
			writer.println("</td>");
			writer.println("</tr>");
		}
		writer.println("</table>");
	}

}
