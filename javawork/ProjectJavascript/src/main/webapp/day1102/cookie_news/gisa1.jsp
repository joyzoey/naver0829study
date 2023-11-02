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
</style>
</head>
<%
	Cookie []cookies=request.getCookies();
	boolean find=false;
	if(cookies!=null){
		for(Cookie ck:cookies){
			//저장된 쿠키 이름 얻기
			String name=ck.getName();
			if(name.equals("loginok")){
				find=true;
			}
		}
	}
%>
<body>
<%
	if(!find){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
		
	<%}else{%>
	<pre style="width:500px;">

애플이 내년부터 스마트워치인 '애플워치'에 건강 관리 기능을 추가할 전망이다.
블룸버그 통신은 1일(현지시간) 내년도 애플워치는 혈압 상승을 감지하는 기능이 추가될 것이라고 전했다. 새로운 센서가 탑재되어 혈압이 올라갈 때 이를 이용자에게 알려주는 기능으로, 새로운 혈압 일지(journal)와 결합해 이용자에게 고혈압이 발생했을 때 어떤 일이 일어났는지 기록할 수 있게 된다.
초기 버전은 정확한 수치까지 보여주지 않지만, 애플인 이를 위한 후속 작업을 하고 있는 것으로 알려졌다.
수면 무호흡증 감지 기능도 추가된다.
사용자의 수면과 호흡 패턴을 모니터링해 수면 무호흡증 여부를 판단하는 것이다. 이를 통해 사용자에게 의사와의 상담 등 후속 조치를 추천하게 된다.
애플은 새로운 유료 건강 서비스 도입도 추진 중이다.
구체적인 내용은 알려지지 않았으나, 인공지능(AI)과 이용자 기기의 정보를 이용해 개별화된 운동과 식사 계획을 추천하는 서비스가 논의되고 있다.
현재 애플은 당뇨병 조기 진단을 위한 혈당 측정 기능도 개발하고 있다. 피부 아래에 빛을 비춰 체내 포도당 농도를 측정하는 방식이다. 다만 블룸버그 통신은 이 기능이 최소 몇 년 간 도입되지 않을 것으로 보인다고 덧붙였다.
한편, 애플은 애플워치 출시 10주년을 맞아 내년에 대대적인 업그레이드를 준비하는 것으로 알려졌다. 2014년 9월 처음 공개된 애플워치는 내년에 10주년을 맞는다.
	</pre>	
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>