<%@page import="inquireboard.data.InquireBoardDto"%>
<%@page import="inquireboard.data.InquireBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
<% 
	//dao 선언
	InquireBoardDao dao=new InquireBoardDao();
	
	//전체 데이타 가져오기
	List<InquireBoardDto>list=dao.getAllList();
	//날짜 출력하기 위한 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.");
%>

</head>
<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>
	<div style="margin:100px 100px;">
		<button onclick="location.href='../login/loginmain.jsp'">돌아가기</button>
		<h5><br><b>총 <%=list.size() %>개의 문의글이 있습니다.</b></h5>
		<br>
		<table class="table table-bordered" style="width:700px;">
			<thead>
				<tr>
					<th width="80">번호</th>
					<th width="300">제목</th>
					<th width="80">작성자</th>
					<th width="140">작성일</th>
					<th width="100">삭제</th>
				</tr>
			</thead>
			<tbody>
			<% 
			if(list.size()==0){%>
				<tr height="50">
					<td colspan="4" align="center">
						<h5>등록된 글이 없습니다.</h5>
					</td>
				</tr>
			<%} else{
				int n=0;
				for(InquireBoardDto dto:list)
				{%>
					<tr align="center">
						<td><%=list.size()-n++ %></td>
						<td align="left">
							<a href="content.jsp?num=<%=dto.getNum()%>">
							<%=dto.getSubject() %>
							</a>
						</td>
						<td><%=dto.getWriter() %></td>
						<td><%=sdf.format(dto.getWriteday()) %></td>
						<td>
							<button type="button" class="btn btn-sm btn-danger del"
							num="<%=dto.getNum()%>">삭제</button>
						</td>
					</tr>
				<%}
			}
			%>
			</tbody>
		</table>
				<script type="text/javascript">
				$(document).on("click",".del",function(){
				let num=$(this).attr("num");
				
				let a=confirm("삭제하려면 [확인]을 눌러주세요");
				if(a){
					location.href="boardDelete.jsp?num="+num;
				}
			});
		</script>
	</div>
	</body>
	</html>