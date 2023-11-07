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
	<style>
		
		
		div{
			font-family: 'Nanum Pen Script';
			font-size: 30px;
		}
					
		
	</style>
</head>
<body>
	<header>
		<jsp:include page="/common/header.jsp"/>
	</header>

	<div style="margin-top:50px; margin-left:100px;">
		<div>
			저희 가게의 모든 제품은 T2제품으로<br>
			1996년 호주 멜버른에서 처음 시작된 T2는
			차를 사랑하는 사람들과 더 좋은 세상을 위해 만들어졌습니다.<br>
			재활용 가능한 종이상자와 친환경 비닐봉투안에 신선하게 밀봉되어 있으며,
			티백은 식용 옥수수 전분으로 만들어져 안전합니다.<br><br>
			영상으로 T2의 제품을 만나보세요.<br>
		</div>
	
		<div class="video">
			<iframe width="1120px" height="630px" 
			src="https://www.youtube.com/embed/XIrFWqYObFA?controls=0&amp;mute=1&amp;autoplay=1&amp;loop=1&amp;playlist=XIrFWqYObFA" 
			title="YouTube video player" 
			allow="accelerometer; autoplay; clipboard-write; 
			encrypted-media; gyroscope; picture-in-picture" ></iframe>
		</div>		
		
	</div>
	
	<footer style="position: absolute;bottom: 0;width:100%">
		<jsp:include page="/common/footer.jsp"/>
	</footer>
</body>
</html>