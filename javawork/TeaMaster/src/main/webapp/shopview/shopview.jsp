<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
   rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
    div.shopicon{
    	margin: 30px 100px;
    }
    div.shopicon *{
    	cursor: pointer;
    	margin-right: 30px;
    	font-size:50px;
    }
    div.list{
    	font-size: 20px;
    }
	div.box{
		display: inline-block;
		width:280px;
		height:500px;
		text-align: center;
		border:5px solid gray;
		border-radius: 20px;
		margin: 10px;
		font-size: 30px;
	}
	div.box figure img{
		width: 250px;
		height: 250px;
		border-radius: 30px;
		margin-top: 10px;
	}
	
	.content {
		position: relative;
		height: 100vh;
	}
	
</style>

<script type="text/javascript">
	$(function(){
		//처음 시작시 그리드 모양 이미지 형태로 출력
		list();
		$(".shoplist").css("color","tomato");
		
		$(".shopgrid").click(function(){
			$(this).css("color","tomato");
			$(".shoplist").css("color","black");
			grid();
		});
		
		$(".shoplist").click(function(){
			$(this).css("color","tomato");
			$(".shopgrid").css("color","black");
			list();
		});
		
		function grid(){
			$.ajax({
				type:"get",
				dataType:"xml",
				url:"shopxml.jsp",
				success:function(res){
					let s="";
					$(res).find("shop").each(function(idx,item){
						let product=$(item).find("product").text();
						let teatype=$(item).find("teatype").text();
						let price=$(item).find("price").text();
						let amount=$(item).find("amount").text();
						let photo=$(item).find("photo").text();
						let writeday=$(item).find("writeday").text();
						
						s+=
						`
						<div class="box">
							<figure>
								<img src="../shop/\${photo}">
								<figcaption>
									<b style="font-size:33px">\${product}</b><br>
									<span style="color:gray; font-size:20px">\${amount}g/\${teatype}</span><br>
									<span>\${price}원</span><br><br>
									<span style="color:gray; font-size:20px">\${writeday}</span>
								</figcaption>
							</figure>
						</div>
						`;
						
					});
					
					$(".list").html(s);
				},
				statusCode:{
					404:function(){
						alert("json 파일을 찾을 수 없어요!");
					},
					500:function(){
						alert("서버오류.. 코드를 다시한번 보세요");
					}
				}
			});
		}
		function list(){
			$.ajax({
				type:"get",
				dataType:"xml",
				url:"shopxml.jsp",
				success:function(res){
					let s="";
					s+=
						`
						<div style="height:750px;">
						<table class="table table-bordered shoptb" style="text-align:center;">
							<thead>
								<tr>
									<th width="50">번호</th>
									<th width="200">상품명</th>
									<th width="100">타입</th>
									<th width="100">가격</th>
									<th width="80">용량</th>
									<th width="150">등록일</th>
								</tr>
							</thead>
						`;
					$(res).find("shop").each(function(idx,item){
						let product=$(item).find("product").text();
						let teatype=$(item).find("teatype").text();
						let price=$(item).find("price").text();
						let amount=$(item).find("amount").text();
						let photo=$(item).find("photo").text();
						let writeday=$(item).find("writeday").text();
						
						s+=
						`
						<tbody>
							<tr>
								<td>\${idx+1}</td>
								<td align="left">
									<img src="../shop/\${photo}" width=40 height=40 border=1
										hspace=5>
										\${product}
								</td>
								<td>\${teatype}</td>
								<td align="right">\${price}원</td>
								<td>\${amount}g</td>
								<td>\${writeday}</td>
							</tr>
						</tbody>
						`;
					});	
						
					s+="</table></div>";
					$(".list").html(s);
				},
				statusCode:{
					404:function(){
						alert("json 파일을 찾을 수 없어요!");
					},
					500:function(){
						alert("서버오류.. 코드를 다시 한번 보세요");
					}
				}
			});
		}
	});
</script>

</head>
<body>
	<div class="content">
		<header>
		<jsp:include page="/common/header.jsp"/>
		
		</header>
	
		<div style="margin:50px 100px; position: relative;">
			<div class="shopicon">
				<i class="bi bi-grid shopgrid"></i>
				<i class="bi bi-card-list shoplist"></i>
			</div>
		
			<div class="list">
				
			</div>
		</div>
		
		<footer style="width: 100%; ">
			<jsp:include page="/common/footer.jsp"/>
		</footer>
	</div>
	
</body>
</html>