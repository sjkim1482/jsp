<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String rep = (String)request.getAttribute("request");
	String ses = (String)session.getAttribute("session");
	String app = (String)getServletContext().getAttribute("application");
%>
<html>
<head>

<script>
	var test = "<%=application.getAttribute("application") %>"
	
	<%-- 클라이언트에서는 서버 사이드 변수 값을 활용할 수 있으나
		 서버 사이드 변수에 클라이언트 변수 값을 대입할 수는 없다 --%>
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request : <%=rep %> </h2>
	<h2>session : <%=ses %> </h2>
	<h2>application : <%=app %> </h2>
</body>
</html>