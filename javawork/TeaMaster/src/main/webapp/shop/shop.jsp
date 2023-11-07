<%@page import="teashop.data.TeaShopDto"%>
<%@page import="teashop.data.TeaShopDao"%>
<%@page import="java.util.List"%>
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

    
    div.box{
     	width:60px;
     	height: 60px;
     	border:1px solid black;
     	border-radius:100px;
    }
    
    img.small{
    	width:50px;
    	height:50px;
    	cursor:pointer;
    	border:1px solid black;
    	margin-right:5px;
    }
    .shoptb{
		font-size: 20px;
	}
    
</style>
<script type="text/javascript">
	$(function(){
		//작은 이미지 클릭시 num얻어서 myshopDetail.jsp로 이동
		$("img.small").click(function(){
			let num=$(this).attr("num");
			//페이지 이동
			//location.href="myshopDetail.jsp?num="+num;
			//es6의 리터럴 문자 사용시 jsp자체적으로 $기능이 있으므로 앞에 \를 붙여서 변수 가져와야 함
			location.href=`shopDetail.jsp?num=\${num}`;
			
		});
	});

</script>

</head>
<body>
<% 
	//dao 선언
	TeaShopDao dao=new TeaShopDao();
	//List가져오기
	List<TeaShopDto> list=dao.getAllproducts();
	//날짜 출력하기 위한 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>
	<div style="margin:100px;">
		<button onclick="location.href='../login/loginmain.jsp'">돌아가기</button>
		<div class="input-group">
			<h5 style="width:800px;"><br>총 <%=list.size() %>개의 상품이 있습니다.
			<i class="bi bi-plus-circle shopinsert" onclick="location.href='shopinform.jsp'">제품등록</i>
			</h5>
		</div>
		<table class="table table-bordered shoptb" style="text-align:center">
			<thead>
				<tr>
					<th width="50">번호</th>
					<th width="200">상품명</th>
					<th width="100">타입</th>
					<th width="100">가격</th>
					<th width="80">용량</th>
					<th width="150">등록일</th>
					<th width="80">삭제</th>
				</tr>
			</thead>
			<tbody>
			<% 
				int n=0;
				for(TeaShopDto dto:list)
				{%>
					<tr align="center">
						<td><%=++n %></td>
						<td align="left">
							<img class="small" src="../shop/<%=dto.getPhoto() %>"
								num="<%=dto.getNum()%>">
							<%=dto.getProduct() %>
						</td>
						<td><%=dto.getTeatype() %></td>
						<td align="right"><%=dto.getPrice() %>원</td>
						<td><%=dto.getAmount() %>g</td>
						<td><%=sdf.format(dto.getWriteday()) %></td>
						<td>
							<button type="button" class="btn btn-sm btn-danger del"
							num="<%=dto.getNum()%>">삭제</button>
						</td>
					</tr>
				<%}
			%>
			
			</tbody>
		</table>
		<script type="text/javascript">
			$(document).on("click",".del",function(){
				let num=$(this).attr("num");
				
				let a=confirm("삭제하려면 [확인]을 눌러주세요");
				if(a){
					location.href="shopDelete.jsp?num="+num;
				}
			});
		</script>
	</div>	

</body>
</html>