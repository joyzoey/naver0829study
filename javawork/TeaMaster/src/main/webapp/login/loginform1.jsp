<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../libs/css/output.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="../libs/js/lottie.min.js"></script>
<style>
    body * {
        font-family: 'Jua';
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
	<form action="loginaction.jsp" method="post">
		<table class="table table-bordered" style="width:300px;border: 5px groove gray;">
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
					<button type="submit" style="width:100%;height:100px;">로그인</button>
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
	
	<div id="animContainer" class="h-28 w-28 rounded-full bg-white mt-4 md:mt-4 md:h-56 md:w-56"></div>
	
	
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