<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서연이네 과일가게</title>

<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<style>
        body * {
            font-family: 'Do Hyeon', sans-serif;
        }

        header {
            background-color: #F5A9A9;
            color: #fff;
            text-align: center;
            padding: 70px;
        }

        img {
            width: 300px;
            height: 200px;
            border: 4px deeppink;
            border-radius: 20px;
            cursor: pointer;
        }

        img.slider-image {
            width: 500px;
            height: 400px;
        }



</style>
</head>
<body>
<header>
    <h1>서연이네 과일가게</h1>
    <button type="button" onclick="location.href='../marketmain.jsp'">돌아가기</button>
</header>

<div style="display: flex; place-content: center; margin-top: 50px;">
    <div class="left">
        <div style="margin: 10px;" class="sw-main">
            <div class="swiper-container mySwiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide"><img src="../fruitmarket/apple.png" class="slider-image"></div>
                    <div class="swiper-slide"><img src="../fruitmarket/apple2.png" class="slider-image"></div>
                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
            </div>
        </div>
    </div>
    
   
      <table class="table table-bordered" style="width: 400px; margin-left:20px;">
               <caption align="top">싱싱 사과 [3kg / 5kg]</caption>
               <tr>
                  <td width="100">가격</td>
                  <td width="300">16,000원</td>
               </tr>
               <tr>
                  <td width="100">원산지</td>
                  <td width="300">충청남도 홍성군</td>
               </tr>
               <tr>
                  <td width="100">생산자</td>
                  <td width="300">홍길동</td>
               </tr>
               <tr>
                  <td width="100">배송 방법</td>
                  <td width="300">택배</td>
               </tr>
               <tr>
                  <td width="100">배송 안내</td>
                  <td width="300">제주 및 도서 산간 지역 배송 불가</td>
               </tr>
               <tr>
                  <td width="100">용량 선택</td>
                  <td>
                     <select class="form-select" name="num" id="num">
                        <option>3kg</option>
                        <option>5kg</option>
                     </select>
                  </td>
               </tr>
               <tr>
                  <td width="100">갯수 선택</td>
                   <td>
                      <input type="number" value="1">박스
                   </td>
               </tr>
               <tr>
                  <td colspan="2" align="center">
                     <button id="btn1">장바구니</button>
                     <button id="btn2">결제하기</button>
                     
                     <script>
                        document.getElementById("btn1").onclick=function(){
                           alert("장바구니에 담겼습니다.")
                        };
                        document.getElementById("btn2").onclick=function(){
                           alert("결제되었습니다.")
                        };
                        
                     </script>
                     
                  </td>
            
               </tr>
       </table>
   </div>
   
   <!-- Swiper 슬라이더를 초기화하는 스크립트 -->
	<script>
	    var mySwiper = new Swiper(".mySwiper", {
	        navigation: {
	            nextEl: '.swiper-button-next',
	            prevEl: '.swiper-button-prev',
	        },
	    });
	</script>

</body>
</html>


























