<%@page import="java.util.Date" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="org.lanqiao.study.web.model.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- <%@include file="login.html" %> -->
<%
	List<Book> books = new ArrayList<>();
	books.add(new Book(1, "Java编程思想", 88f, new Date()));
	books.add(new Book(2, "JavaWeb开发", 128f, new Date()));
	books.add(new Book(3, "数据库开发", 99f, new Date()));
%>
<body>
	<table cellpadding="5" border="1">
		<tr>
			<td>标识</td>
			<td>名称</td>
			<td>价格</td>
			<td>出版日期</td>
		</tr>
		<%
			for (Book book : books) {
		%>
		<tr>
			<td><%=book.getId() %></td> <!-- 等同于println(book.getId()) -->
			<td><%=book.getName() %></td>
			<td><%=book.getPrice() %></td>
			<td><%=book.getPublish() %></td>
		</tr>
		<%
			}
		%>
		<%! private String sssss = "";  %> <!-- 成员变量 -->
		
		<%
			request.getAttribute("aaa");
			response.getWriter().print("11111111");
			//session; => httpSession
			//page 当前页面对象
			//pageContext.getAttribute("");
			//application.getAttribute("") => ServletContext
			//out => response.getWriter()
		%>
	</table>
</body>
</html>