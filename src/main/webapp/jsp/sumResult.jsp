<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%=session.getAttribute("start") %>에서 
		<%=session.getAttribute("end") %>까지 
		합 : 
		<%=session.getAttribute("sumResult") %>
	</h1>
</body>
</html>