<%@page import="java.util.Date" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="org.lanqiao.study.web.model.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	List<Book> books = new ArrayList<>();
	books.add(new Book(1, "Java编程思想", 88f, new Date()));
	books.add(new Book(2, "JavaWeb开发", 128f, new Date()));
	books.add(new Book(3, "数据库开发", 1111111199f, new Date()));
	pageContext.setAttribute("books", books);
	pageContext.setAttribute("message", "Hello World");
%>
<body>
	<c:forEach begin="0" end="10">
		hahaha<br/>
	</c:forEach>
	<c:if test="${param.name == 'admin' }">
		你好，管理员
	</c:if>
	<c:choose>
		<c:when test="${param.name=='admin' && param.password=='123' }">
			登陆成功
		</c:when>
		<c:otherwise>
			没有权限
		</c:otherwise>
	</c:choose>
	
	<h1>forEach迭代集合</h1>
	<table>
		<c:forEach items="${books }" var="book">
			<tr>
				<td>
					${index }
				</td>
				<td>
					${book.id }
				</td>
				<td>
					${book.name }
				</td>
				<td>
					<fmt:formatNumber value="${book.price }" currencySymbol="," />
				</td>
				<td>
					<fmt:formatDate value="${book.publish }" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
			</tr>
		</c:forEach>	
	</table>
	<h1>fn</h1>
	${fn:length(message) }
	${fn:split(message, " ") }
</body>
</html>

<%--
	函数名 函数说明 使用举例
	fn:contains					判断字符串是否包含另外一个字符串（${fn:contains(name, searchString)）
	fn:containsIgnoreCase	判断字符串是否包含另外一个字符串（大小写无关）（${fn:containsIgnoreCase(name, searchString) }）
	fn:endsWith					判断字符串是否以另外一个字符串结束（${fn:endsWith(filename, 'txt') }）
	fn:escapeXml					把一些字符转成XML表示，例如“<”字符应该转为“&lt”（${fn:escapeXml(param:info) }）
	fn:indexOf					子字符串在母字符串中出现的位置（${fn:indexOf(name, "-") }）
	fn:join							将数组中的数据联合成一个新字符串，并使用指定字符隔开（${fn:join(array, ";") }）
	fn:length						获取字符串的长度，或者数组的大小（${fn:length(shoppingCart.products) }）
	fn:replace						替换字符串中指定的字符（${fn:replace(text, "-", "&#149") }）
	fn:split							把字符串按照指定字符切分（${fn:split(customerNames, ";") }）
	fn:startsWith				判断字符串是否以某个子串开始（${fn:startsWith(product.id, "100-") }）
	fn:substring					获取子串（${fn:substring(zip, 6, -1) }）
	fn:substringAfter			获取从某个字符所在位置开始的字符串（${fn:substringAfter(zip, "-") }）
	fn:substringBefore			获取从开始到某个字符所在位置的子串（${fn:substringBefore(zip, "-") }）
	fn:toLowerCase				转为小写字符（${fn:toLowerCase(product.name) }）
	fn:toUpperCase				转为大写字符（${fn:toUpperCase(product.name) }）
	fn:trim							去除字符串前后的空格（${fn:trim(name) }）
--%>