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
네이버웹툰이 최근 미국에서 소환장(Subpoena) 발부를 신청해 자사 웹툰 80여개를 무단으로 게시한 웹툰 불법 공유 사이트 150여곳의 활동을 중단시켰다고 2일 밝혔다.
소환장은 미국 디지털 밀레니엄 저작권법(DMCA)에서 근거한 저작권 침해 피의자를 식별용 문서 제출 명령을 뜻한다.
소환장을 송달받은 서비스 제공자는 저작권 침해 피의자의 이메일부터 주소, 결제 정보까지 상세한 개인정보를 제출해야 한다. 이는 불법 사이트 운영자 검거에 꼭 필요한 정보기도 하다.
네이버웹툰은 올 7월 미국 법원에 360여개 불법 사이트 운영자 개인정보 소환장 발부를 신청했고, 곧이어 미국의 대형 콘텐츠 전송 네트워크사(社)에 개인정보 제출 명령이 떨어졌다.
이후 3개월 만에 아쿠아만가, 플레임스캔스 등 150여개 불법 웹툰 공유 사이트가 완전히 삭제되거나 운영을 중단했다.
운영자들이 계속 웹사이트를 운영하려면 자신의 개인정보를 제출해야 하므로 이를 피하기 위해 활동 중단을 택한 것으로 보인다.
이들 웹사이트의 연간 이용자 방문 트래픽은 약 25억회에 달하는 것으로 파악된 만큼 웹툰 불법 이용을 크게 막아낸 효과를 낸 셈이다.
네이버웹툰은 소환장을 통해 확보한 불법 사이트 운영자 정보를 수사기관과 공유하고 추적을 이어 나갈 계획이다.
	</pre>	
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>