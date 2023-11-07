<%@page import="teashop.data.TeaShopDto"%>
<%@page import="teashop.data.TeaShopDao"%>
<%@page import="java.text.SimpleDateFormat"%>

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
	String num=request.getParameter("num");
	//dao 선언
	TeaShopDao dao=new TeaShopDao();	
	
	//dto 얻기
	TeaShopDto dto=dao.getproduct(num);
	
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm");

%>

<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>
	<div style="margin:100px;">

		<div style="margin:30px 50px">
			<h4><b>&nbsp;&nbsp;&nbsp;&nbsp;<%=dto.getProduct() %></b></h4>
			<br>
			<img src="<%=dto.getPhoto()%>"
				style="width: 300px; border: 5px inset gray;"
				align="left" hspace="20">
			<br><br><br><br>
			제품 명 : <%=dto.getProduct()%>
			<br><br>
			타   입 : <%=dto.getTeatype()%>
			<br><br>
			가   격 : <%=dto.getPrice()%>원
			<br><br>
			용   량 : <%=dto.getAmount()%>g
			<br><br>
			등록 일 : <%=sdf.format(dto.getWriteday()) %>
		</div>
		<div class="buttons" style="margin-left :400px;">
			<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='shopUpdateform.jsp?num=<%=dto.getNum() %>'">수정</button>
			
			<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='shopDelete.jsp?num=<%=dto.getNum() %>'">삭제</button>
			
			<button type="button" class="btn btn-outline-secondary"
			onclick="location.href='shop.jsp?'">목록</button>
		</div>
	</div>
</body>
</html>