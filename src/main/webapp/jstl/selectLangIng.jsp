<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_lib.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp}/js/jquery-1.12.4.js"></script>
<script>
	$(function() {
		$(".select").on("change", function() {
			$("#frm").submit();
		})
		
	})
</script>
</head>
<body>
	<form id="frm" action="${cp}/changeLang">
		<select class="select" name="lang">
			<option value="ko" ${kor}>한국어</option>
			<option value="en" ${eng}>english</option>
			<option value="ja" ${jap}>日本語</option>
			<option value="de" ${def}>기타</option>
		</select>
	</form>
	<%-- select box로 설정한 언어로 GREETING, LANG 값을 표현
		 select box는 사용자가 설정한 언어 값으로 선택이 되어있게 설정
	 --%>

	<fmt:setLocale value="${lang}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="LANG"/>	<br>	
		<fmt:message key="GREETTING" > 
			<fmt:param value="brown"/>
		</fmt:message><br>
	</fmt:bundle>
</body>
</html>