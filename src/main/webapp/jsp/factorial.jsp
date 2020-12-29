<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jsp 메소드, 변수 선언부 --%>
<%! 
	public int caculate(int n){
		if(n <= 1){
			return 1;
		}else{
			return n * caculate(--n);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1! : <%=caculate(1) %> </h3>
	<h3>2! : <%=caculate(2) %> </h3>
	<h3>3! : <%=caculate(3) %> </h3>
	<h3>4! : <%=caculate(4) %> </h3>
	<h3>5! : <%=caculate(5) %> </h3>
</body>
</html>