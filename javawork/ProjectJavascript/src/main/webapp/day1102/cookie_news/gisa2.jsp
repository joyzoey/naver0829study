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
SK텔레콤 컨소시엄이 신세계프라퍼티가 개발 중인 화성국제테마파크를 시작으로 국내 도심항공교통(UAM) 생태계 조성을 위한 협력을 본격화한다.
SK텔레콤·한국공항공사·한화시스템·티맵모빌리티가 참여하는 ‘한국형(K)-UAM 드림팀’ 컨소시엄은 2일 신세계프라퍼티와 화성국제테마파크 UAM 사업 추진을 위한 업무협약(MOU)을 체결했다.
UAM은 전기로 구동하는 전기수직이착륙기 기반 항공 이동 서비스로 도심에서 활주로 없이 수직 이착륙이 가능하고 다양한 육상 교통수단과 연계 가능한 친환경 이동수단이다.
SK텔레콤 컨소시엄과 신세계프라퍼티는 화성국제테마파크 안에 UAM 서비스 구현을 추진한다. UAM 이착륙과 항행에 필요한 시설인 버티포트를 건설하고 사람들이 UAM 기체를 타고 이동하는 서비스를 제공할 수 있도록 협력하는 게 골자다.
화성국제테마파크 사업은 신세계프라퍼티가 경기 화성시 송산그린시티 내 418만9000㎡ 부지에 미래형 첨단 복합도시를 건립하는 프로젝트다. 신세계프라퍼티는 여기에 테마파크, 호텔, 레지던스, 쇼핑몰, 골프장 등을 설립하고 UAM과 자율주행 등 미래형 모빌리티 환경을 구축할 계획이다.
	</pre>	
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>