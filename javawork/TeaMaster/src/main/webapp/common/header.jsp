<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-element-bundle.min.js"></script>
		
		<style>
			header {
				border-bottom: 5px solid #ccc;
			    position: relative;
			    height: 100px;
			}
		    .headerleft {
		    	font-family: 'Jua';
		        font-size : 30px;
		        color : gray;
		    	display : inline-block;
		    	position:absolute;
		    	left : 100px;
		    	top : 50px;
		    }
		    .headerright {
		    	font-family: 'Jua';
		        font-size : 30px;
		        color : gray;
		    	position:absolute;
		    	top : 50px;
		    	right : 100px;
		    }
		    i {
		    	cursor: pointer;
		    }
		    .headerhr {
		    	position:absolute;
		    	top : 60px;
		    }

    	</style>
	</head>
	
	<body>
		<div class="headerleft">
		   <label onclick="location.href='../home/index.jsp'">
		      <i class="bi bi-house-fill">&nbsp;HOME</i>
		   </label> &nbsp;&nbsp;
		   <label onclick="location.href='../AboutUs/AboutUs.jsp'">
		      <i class="bi bi-newspaper">&nbsp;AboutUs</i>
		   </label> &nbsp;&nbsp;
		   <label onclick="location.href='../shopview/shopview.jsp'">
		      <i class="bi bi-cart2">&nbsp;SHOP</i>
		   </label> &nbsp;&nbsp;
		   <label onclick="location.href='../ContactUs/ContactUs.jsp'">
		      <i class="bi bi-person-workspace">&nbsp;ContactUs</i>
		   </label> &nbsp;&nbsp;
		</div>
		<div class="headerright">
		   <label onclick="location.href='../login/loginmain.jsp'">
		      <i class="bi bi-person-circle">&nbsp;Manage</i>
		   </label>
		</div>
	</body>
</html>