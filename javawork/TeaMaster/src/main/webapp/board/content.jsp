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
	//num �б�
	String num=request.getParameter("num");
	//dao ����
	InquireBoardDao dao=new InquireBoardDao();
	
	//num�� �ش��ϴ� dto ���
	InquireBoardDto dto=dao.getDate(num);
	//��¥ ��� ���
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>
<body>
<header>
		<jsp:include page="/common/header.jsp"/>
</header>
<div style="margin: 100px 100px">
	<table class="table table-bordered" style="width: 500px">
		<tr>
			<td style="width: 150px">����</td>
			<td><%=dto.getSubject() %></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td><%=sdf.format(dto.getWriteday()) %></td>
		</tr>
		<tr>
			<td>����ó</td>
			<td><%=dto.getPhone() %></td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td><%=dto.getMail() %></td>
		</tr>
		<tr height="300" valign="top">
			<td colspan="2">
				<%=dto.getContent().replace("\n", "<br>") %>
				<!-- �������ϰ�� replace�� \n�� <br>�� �����ϰų�
					<pre>�±׷� ����� �ؾ߸� �ٳѱ��� �ȴ� -->
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='list.jsp'">���</button>
					
				<button type="button" class="btn btn-outline-success"
					style="width:100px;" onclick="location.href='boardDelete.jsp?num=<%=dto.getNum() %>'">����</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>