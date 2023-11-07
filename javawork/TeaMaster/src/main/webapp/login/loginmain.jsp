<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	
	<style>
	    body * {
	        font-family: 'Jua';
	    }
	</style>
</head>
<% 
	//로그인 상태인지 세션값을 얻는다
	String loginok=(String)session.getAttribute("loginok");
	
%>

<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>

	
	<div style="margin:100px;">
		<% 
		if(loginok==null){%>
			<jsp:include page="loginform.jsp"/>
			<br><br>
		<%} else{%>
			<jsp:include page="logoutform.jsp"/>
			<br><br>
			<button type="button" onclick="location.href='../shop/shop.jsp'">제품 관리</button>
			<button type="button" onclick="location.href='../board/list.jsp'">문의 관리</button>
		<%}
		%>
	</div>
</body>
</html>