<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&family=Gamja+Flower&family=Hahmlet&family=Orbit&family=Pacifico&family=Salsa&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Moirai+One&display=swap" rel="stylesheet">
<style>
    body * {
        
        font-family: 'Orbit';
    }
    
    ul.menu{
   		list-style: none;
   		width: 800px;
   		height: 80px;
   		margin-left:100px;
   }
   ul.menu li{
   	float: left;
   	width: 100px;
   	height: 50px;
   	line-height: 50px;
   	font-size: 20px;
   	border: 2px solid #CA8462;
   	border-radius: 30px;
   	box-shadow: 3px 3px 3px #CA8462;
   	margin-right: 10px;
   	color:#CA8462;
   }
   ul.menu li:hover{
   	background-color: pink;
   	
   }
   ul.menu li a{
   	cursor: pointer;
   }
   ul.menu li a:hover{
   	color:magenta;
   }
    
</style>
</head>
<body>
<!--font-family: 'Moirai One';-->
<h1 style="color:gray;">커뮤니티 > <b style="color:black">F&Q</b></h1>
<button style="background-color:GRAY;color:white;border:none;  text-align:center;">작성</button>
<br>
<h1 style="color:black;"><b>&nbsp;추천코스 Q & A Q&A 정보 자유게시판</b></h1>
<h1 style="background-color:#CA8462;color:white;text-align : center;"><b>&nbsp;&nbsp; 자유게시판 관리 &nbsp; <br>&nbsp; 1:1 문의 관리&nbsp;<br>&nbsp;  여행지 관리&nbsp;<br>&nbsp;  코스 관리</b></h1>
<h1 style="background-color:#EEB182;color:#CA8462;text-align : center;"><b>&nbsp;&nbsp; 내프로필 &nbsp; <br>&nbsp; 나의여행코스&nbsp;<br>&nbsp;  활동기록&nbsp;<br>&nbsp;  자유게시판</b></h1>
</body>

<ul class="menu">
	<li style="text-align: center;">
		<b>찜목록</b>
	</li>
	<li style="text-align: center;">
		<b>가본곳목록</b>
	</li>
	<li style="text-align: center;">
		<b>내 게시글</b>
	</li>
	<li style="text-align: center;">
		<b>내정보확인</b>
	</li>
	
</ul>

</html>