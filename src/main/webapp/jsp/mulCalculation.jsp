<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/mulCalculation" method="post">
		<input type="text" name="start" > *
		<input type="text" name="end" >
		<input type="submit" value="결과">
	</form>
</body>
</html>