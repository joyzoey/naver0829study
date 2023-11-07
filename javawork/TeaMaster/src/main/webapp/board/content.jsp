<%@page import="java.text.SimpleDateFormat"%>
<%@page import="inquireboard.data.InquireBoardDto"%>
<%@page import="inquireboard.data.InquireBoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	//num 읽기
	String num=request.getParameter("num");
	//dao 선언
	InquireBoardDao dao=new InquireBoardDao();
	
	//num에 해당하는 dto 얻기
	InquireBoardDto dto=dao.getDate(num);
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>
<body>
<header>
		<jsp:include page="/common/header.jsp"/>
</header>
<div style="margin: 100px 100px">
	<table class="table table-bordered" style="width: 500px">
		<tr>
			<td style="width: 150px">제목</td>
			<td><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=sdf.format(dto.getWriteday()) %></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><%=dto.getPhone() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=dto.getMail() %></td>
		</tr>
		<tr height="300" valign="top">
			<td colspan="2">
				<%=dto.getContent().replace("\n", "<br>") %>
				<!-- 여러줄일경우 replace로 \n을 <br>로 변경하거나
					<pre>태그로 출력을 해야만 줄넘김이 된다 -->
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='list.jsp'">목록</button>
					
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='boardDelete.jsp?num=<%=dto.getNum() %>'">삭제</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>