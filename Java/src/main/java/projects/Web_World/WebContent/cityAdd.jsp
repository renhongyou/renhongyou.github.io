<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
</head>
<body>
	<form action="cityAdd" method="post">
		城市名称<input name="name" /><br/>
		所在国家<input name="countryCode" /><br/>
		所在地区<input name="district" /><br/>
		人口<input name="population" /><br/>
		<input type="submit" /><br/>
	</form>
</body>
</html>