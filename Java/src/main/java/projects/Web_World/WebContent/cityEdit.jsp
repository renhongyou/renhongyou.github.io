<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑城市</title>
</head>
<body>
	<form action="cityUpdate" method="post">
		<input type="hidden" name="id" value="${requestScope.editCity.id }"/>
		城市名称<input name="name" value="${requestScope.editCity.name }" /><br/>
		所在国家<input name="countryCode" value="${requestScope.editCity.countryCode }" /><br/>
		所在地区<input name="district" value="${requestScope.editCity.district }" /><br/>
		人口<input name="population" value="${requestScope.editCity.population }" /><br/>
		<input type="submit" /><br/>
	</form>
</body>
</html>