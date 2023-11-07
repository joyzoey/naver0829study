<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-element-bundle.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpq2iczfgo"></script>
	
	<style>
				
		h1 {
			font-family: 'Nanum Pen Script';
			margin: auto;
			text-align: center;
		}
		table {
			font-size : 25px;
		}
					
		
	</style>
</head>
<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>

	<div style="margin:100px 100px;">
		<div style="background-color:#ccc; 
		border-radius:50px; text-align:center; height:200px;">
			<h1><br>궁금한 사항을 남겨주세요!<br>작성해주신 상담 내용 확인 후 빠른 답변 드리겠습니다!</h1>
		</div>
		<form action="ContactUsAction.jsp" method="post"
			style="display: flex; place-content: center; text-align: center; 
				margin : 30px; font-family: 'Jua'; ">
			<table class="table table-bordered" style="width: 600px;">
				<caption align="top">상담자 정보</caption>
				<tr>
					<td width="100">이름</td>
					<td>
						<input type="text" name="writer" class="form-control"
							autofocus="autofocus" required="required">
					</td>
				</tr>
				<tr>
					<td width="100">연락처</td>
					<td>
						<input type="text" name="phone" class="form-control"
							required="required">
					</td>
				</tr>
				<tr>
					<td width="100">이메일</td>
					<td>
						<input type="text" name="mail" class="form-control"
							required="required">
					</td>
				</tr>
				<tr>
					<td width="100">제목</td>
					<td class="input-group">
						<input type="text" name="subject" class="form-control"
							required="required">
					</td>
				</tr>
				<tr>
					<td width="100">내용</td>
					<td>
						<textarea style="width: 100%;height: 150px;" name="content" 
							required="required" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-success"
							style="width: 100px">등록</button>
					</td>
				</tr>
			</table>
		<div style="padding-left : 30px">
			<div id="map" style="width:500px; height:400px;">
			<br><br><br><br><br><br><br><br><br><br><br><br><br>
			
				<script>
				var mapOptions = {
						center : new naver.maps.LatLng(37.4994225, 127.0289905),
						zoom:16
				};
				var map= new naver.maps.Map('map', mapOptions);
				
				var markerOptions = {
						position : new naver.maps.LatLng(37.4994225, 127.0289905),
						map : map
				};
				
				var market= new naver.maps.Marker(markerOptions);
				</script>
			</div>
			<div style="background-color:#ccc; width:500px; padding : 20px;
				font-size : 30px; font-family: 'Nanum Pen Script';">
			번호 : 02-1234-5678<br>
			주소 : 서울 강남구 강남대로94길 20, 삼오빌딩 7층
			</div>
		</div>	
			
		</form>
	</div>
	
	<footer style="position: absolute;bottom: 0;width:100%">
		<jsp:include page="/common/footer.jsp"/>
	</footer>
</body>
</html>