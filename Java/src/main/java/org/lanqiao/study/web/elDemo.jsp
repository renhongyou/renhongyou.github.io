<%@page import="java.util.Date" %>
<%@page import="org.lanqiao.study.web.model.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setAttribute("reqMsg", new Book(1, "Java基础", 16.8f, new Date()));
		session.setAttribute("sessionMsg", "我是session域对象的消息");
		application.setAttribute("servletContextMsg", "我是ServletContext域对象的消息");
	%>
	<h1>--------------------------------------</h1>
	el表达式的获取规则：pageContext.findAttribute() -> <br/>
	先找pageContext.getAttribute()再找request.getAttribute()再找session.getAttribute()最后application(ServletContext)<br/>
	el获取request域对象：${reqMsg.name } == <%=pageContext.findAttribute("reqMsg") %><br/>
	el获取session域对象：${sessionMsg }<br/>
	el获取application域对象：${applicationScope.servletContextMsg }<br/>
	el获取请求参数：${param.aaa } --- ${paramValues.bbb[0] }<br/>
	el获取initParam：${initParam.encoding }<br/>
	<h1>--------------------------------------</h1>
	
	pageContext				对应于JSP页面中的pageContext对象（注意：取的是pageContext对象）<br/>
	pageScope					代表page域中用于保存属性的Map对象<br/>
	requestScope				代表request域中用于保存属性的Map对象<br/>
	sessionScope				代表session域中用于保存属性的Map对象<br/>
	applicationScope		代表application域中用于保存属性的Map对象<br/>
	param						表示一个保存了所有请求参数的Map对象<br/>
	paramValues				表示一个保存了所有请求参数的Map对象，它对于某个请求参数，返回的是一个String[]<br/>
	header						表示一个保存了所有http请求头字段的Map对象，注意：如果头里面有“-”，例Accpet-Encoding，则要header["Accept-Encoding"]<br/>
	headerValues				表示一个保存了所有http请求头字段的Map对象，它对于某个请求参数，返回的是一个String[]数组，注意：如果头里面有“-”，例Accpet-Encoding，则要headerValues["Accept-Encoding"]<br/>
	cookie						表示一个保存了所有cookie的Map对象<br/>
	initParam					表示一个保存了所有web应用初始化参数的map对象<br/>
	<h1>--------------------------------------</h1>
	
	运算23+3=${23+3 }<br/>
	运算reqMsg==sessionMsg: ${reqMsg==sessionMsg }
</body>
</html>