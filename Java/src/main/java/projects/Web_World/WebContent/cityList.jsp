<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 城市列表 -->
	<h1>城市列表</h1>
	<a href="cityAdd.jsp">添加城市</a>
	<table>
		<thead>
			<tr>
				<td>标识</td>
				<td>城市名称</td>
				<td>国家</td>
				<td>地区</td>
				<td>人口</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:forEach items="${requestScope.cities }" var="city">
			<tr>
				<td>${city.id }</td>
				<td>${city.name }</td>
				<td>${city.countryCode }</td>
				<td>${city.district }</td>
				<td>${city.population }</td>
				<td><a href="cityDelete?id=${city.id }">删除</a></td>&nbsp;&nbsp;
				<td><a href="cityEdit?id=${city.id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>