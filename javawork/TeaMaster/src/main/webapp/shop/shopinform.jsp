<%@page import="teashop.data.TeaShopDao"%>
<%@page import="teashop.data.TeaShopDto"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
    
    img.showimg{
    	position:absolute;
    	left:550px;
    	top:240px;
    	width: 300px;
    	border: 5px groove lightgray;
    }
    .uploadcamera {
		float: right;
	    display: flow;
	    position: absolute;
	    top: 309px;
	    left: 465px;
    }
</style>
<script type="text/javascript">
	$(function() {
		//카메라 이벤트
		$(".uploadcamera").click(function() {
			$("#upload").trigger("click");//이벤트 강제 발생
		});
		
		//이미지 미리보기 코드
		$("#upload").change(function() {
			console.log("1:" + $(this)[0].files.length);
			console.log("2:" + $(this)[0].files[0]);
			//정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			var f = $(this)[0].files[0];//현재 선택한 파일
			if (!f.type.match(reg)) {
				alert("확장자가 이미지파일이 아닙니다");
				return;
			}
			
			var fileName = $(this)[0].files[0].name;
			
			if ($(this)[0].files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					console.log(e.target);
					$(".showimg").attr("src", e.target.result);
					$("input[name=photo]").val(fileName);
				}
				reader.readAsDataURL($(this)[0].files[0]);
			}
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
%>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>
	<div style="margin:100px;">
		<form action="./shopinsert.jsp" method="post"  enctype="multipart/form-data">
			<table class="table table-bordered" style="width:300px; margin:30px 100px;">
				<caption align="top"><b>제품 등록</b></caption>
				<tr>
					<td align="center" width="100">제품명</td>
					<td>
						<input type="text" name="product" class="form-control"
						required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<td align="center" width="100">사진 선택</td>
					<td>
						<input type="file" name="upload" id="upload"
						style="display:none;">
						<input type="text" name="photo" id="photo">
						<i class="bi bi-camera-fill uploadcamera"></i>
					</td>
				</tr>
				<tr>
					<td align="center" width="100">타입</td>
					<td>
						<input type="text" name="teatype" class="form-control"
						required="required">
					</td>
				</tr>
				<tr>
					<td align="center" width="100">용량</td>
					<td>
						<input type="number" name="amount" class="form-control"
						required="required">
					</td>
				</tr>
				<tr>
					<td align="center" width="100">가격</td>
					<td>
						<input type="number" name="price" class="form-control"
						required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit">DB저장</button>
						<button type="button" onclick="location.href='shop.jsp'">목록보기</button>
					</td>
				</tr>
			</table>
		</form>
		<img src="1.png" class="showimg">
	</div>
</body>
</html>