<%@page import="simpleboarddata.SimpleBoardDto"%>
<%@page import="simpleboarddata.SimpleBoardDao"%>
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
    span.day{
    	font-size: 14px;
    	color: gray;
    }
</style>
</head>
<% 
	//num 읽기
	String num=request.getParameter("num");
	//dao 선언
	SimpleBoardDao dao=new SimpleBoardDao();
	
	//조회수 증가
	dao.updateReadcount(num);
	
	//num에 해당하는 dto 얻기
	SimpleBoardDto dto=dao.getDate(num);
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>
<body>
<div style="margin: 30px 50px">
	<table class="table table-bordered" style="width: 500px">
		<tr>
			<h2><b><%=dto.getSubject() %></b></h2>
			<span><b><%=dto.getWriter() %></b></span>
			&nbsp;&nbsp;
			<span class="day">
				<%=sdf.format(dto.getWriteday()) %>
				&nbsp;
				조회&nbsp;<%=dto.getReadcount() %>
			</span>
		</tr>
		<tr height="300" valign="top">
			<td>
				<% 
				if(!dto.getPhoto().equals("no"))
				{%>
					<img src="../save/<%=dto.getPhoto() %>"
						style="max-width: 300px;border: 1px solid gray;">
					<br><br>			
				<%}
				%>
				<%=dto.getContent().replace("\n", "<br>") %>
				<!-- 여러줄일경우 replace로 \n을 <br>로 변경하거나
					<pre>태그로 출력을 해야만 줄넘김이 된다 -->
			</td>
		</tr>
		<tr>
			<td align="center">
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='boardForm.jsp'">글쓰기</button>
				
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='list.jsp'">목록</button>
					
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='updateForm.jsp?num=<%=dto.getNum() %>'">수정</button>
					
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='boardDelete.jsp?num=<%=dto.getNum() %>'">삭제</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>