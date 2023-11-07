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
<script src="../libs/js/lottie.min.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
    .hotTea {
    	width : 400px;
    }
    .teaSvg {
    	width: 100%;
    	text-align: -webkit-center;
    }
</style>
</head>
<%
	//세션으로부터 아이디와 체크저장값을 얻는다
	String loginid=(String)session.getAttribute("loginid");
	String savestatus=(String)session.getAttribute("savestatus");
	boolean bCheck=false;
	if(savestatus==null || savestatus.equals("no")){
		bCheck=false;
	}else{
		bCheck=true;
	}
	
	//체크 안했을 경우 아이디 없애기
	if(!bCheck) loginid="";

%>

<body>
<div style="margin:30px 100px">
	<h3 style="text-align:center;">관리자 로그인</h3>
	<form action="loginaction.jsp" method="post" style="text-align: -webkit-center;">
		<table class="table table-borderless" style="width:300px;">
			<caption align="top">
				<label>
					<input type="checkbox" name="saveid"
						<%=bCheck?"checked":"" %>>아이디저장
				</label>
			</caption>
		
			<tr>
				<td width=150>
					<input type="text" class="form-control" autofocus required 
						placeholder="아이디" name="loginid" value="<%=loginid %>">
				</td>
				<td rowspan="2" width=100>
					<button type="submit" style="width:100%;height:100px; border : none; background-color : black; color : white;">로그인</button>
				</td>
			</tr>
			<tr>
				<td width=150>
					<input type="password" class="form-control" required
						placeholder="비밀번호" name="loginpass">
				</td>
			</tr>
		</table>
	</form>
	
	<div class="teaSvg">
		<div id="animContainer" class="hotTea"></div>
	</div>
	
</div>
<script>
	var animation = bodymovin.loadAnimation({
	    container: document.getElementById('animContainer'),
	    renderer: 'svg',
	    loop: true,
	    autoplay: true,
	    path: 'https://assets9.lottiefiles.com/packages/lf20_epenpdir.json' // lottie file path
	});
	
	function openReq(id){
	    id = id.split('-')[1]
	    var expandeds = document.getElementsByClassName('res')
	    for(let i = 0; i < expandeds.length; i++){
	        expandeds[i].classList.add('hidden')
	    }
	    document.getElementById(`res-${id}`).classList.remove('hidden')
	}
</script>

</body>
</html>