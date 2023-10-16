<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body * {
        font-family: 'Jua';
    }
     .calendar{
		text-align: -webkit-center;
	}
	.calendar table{
		width: 600px;
		border:5px groove gray;
	}
	.calendar table thead tr{
		height: 30px;
	}
	.calendar table tbody tr{
		height: 100px;
	}
	.calendar table thead tr th{
		font-size: 22px;
		background-color: lightgray;
		color: black;
		text-align: center;
		border-bottom: 3px double gray;
	}
    
</style>

<script>
	window.onload=function(){
		//현월 출력 + 오늘날짜배경색
		updateCalendar();
		$("#td" + curday).css("background-color","lightyellow");
		
		//달력 불러오기 클릭이벤트
		//받아오는 값을 새로운 변수에 넣어주고 에러함수에 넣어서 에러여부 확인
		$("#button-load").click(function(){
			let inYear = $("#year").val();
			let inMonth = $("#month").val();
			let flag = true;
			if(inYear < 1 || inYear > 2400) flag = showError("year");
			if(inMonth < 1 || inMonth > 12) flag = showError("month");
			
			//제대로된 값일때만 현재년월에 넣어주고 에러때 바뀐 css원상복구
			if(flag) {
				curyear = $("#year").val('');
				curmonth = $("#month").val('');
				$('#year').css('border', 'var(--bs-border-width) solid var(--bs-border-color)');
				$('#month').css('border', 'var(--bs-border-width) solid var(--bs-border-color)');
				updateCalendar();
			}			
		});
		
		// 엔터키 이벤트
		$("#year").on('keypress', function(e) {
            if (e.which === 13) $('#button-load').click();
        });
		$("#month").on('keypress', function(e) {
			if (e.which === 13) $('#button-load').click();
        });
		
		//화살표 클릭이벤트
		$('#btn-prev').click(function(){
			//1월일때 전년도로 바꾸고 12월부터
			if(curmonth == 1){
				curyear--;
				curmonth = 12;
			} else curmonth--;
			updateCalendar();
		});
		$('#btn-next').click(function(){
			//12월일때 다음년도로 바꾸고 1월부터
			if(curmonth == 12){
				curyear++;
				curmonth = 1;
			} else curmonth++;
			updateCalendar();
		});
	}
	
	// 불러오기 에러 함수
	function showError(value) {
		alert("입력이 잘못되었습니다.");
		$("#" + value).val('');//초기화
		$("#" + value).css('border', '2px inset red');
		return false;
	}

	//달력 출력 함수
	function updateCalendar()
	{
		$("#current-date").text(curyear + "년 " + curmonth + "월");
	
		//요일숫자(해당월의 1일의 요일)
		let date2 = new Date(curyear, curmonth-1, 1);
		let weekday = date2.getDay();
		
		//해당 년도의 해당월이 몇일까지 있는지 구하기
		let endday;
		switch (curmonth) {
			case 2:
				endday = curyear % 4 == 0 && curyear % 100 != 0 || curyear % 400 == 0 ? 29 : 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				endday = 30;
				break;
			default:
				endday = 31;
		}
		
		//달력만들기-테이블
		//head
		let s=`
			<table class="table table-bordered">
				<caption align="top"></caption>
				<thead>
					<tr>
						<th style="color:red">일</th><th>월</th><th>화</th><th>수</th>
						<th>목</th><th>금</th><th style="color:blue">토</th>
					</tr>
				</thead>
		`;
		
		//body
		s+="<tbody><tr>";
			//전칸그리기
			for (let i = 1; i <= weekday; i++){
				s += "<td></td>";
			}
			//1-endday까지
			for (let i = 1; i <= endday; i++){
				++weekday;
				//id 오늘날짜 찾을 id+토일색상
				s += '<td id="td' + i + '"style="color:' + (weekday % 7 == 1 ? 'red;"' : weekday % 7 == 0 ? 'blue;"' : 'black;"') + '>' + i + '</td>';
				//토요일에 줄바꾸기
				if (weekday % 7 == 0 && i < endday){
					s += "</tr><tr>";
				}else if (weekday % 7 == 0 && i == endday){
					s += "</tr>";
				}
			}
			//나머지칸그리기
			let n = 1;
			if (weekday % 7 != 0){
				while (true){
					weekday++;
					s += '<td style="color:#ccc;">' + n + "</td>";
					n++;
					if(weekday%7==0)
						break;
				}
				s += "</tr>";
			}
		s += "</tbody></table>";
		
		document.querySelector(".calendar").innerHTML=s;
	}
	
</script>

</head>
<body>
	<div class="input-group" style="margin:10px;width:unset; ">
		<span class="input-group-text">연도</span>
		<input type="number" class="form-control" id="year">
		<span class="input-group-text">월</span>
		<input type="number" class="form-control" id="month">
		<button class="btn btn-outline-secondary" type="button" id=	
		"button-load">달력 불러오기</button>
	</div>
	<div class="calendar-title" style="margin-top:10px;text-align: center;">
		<div class="btn-group">
			<button type="button" class="btn btn-secondary" id="btn-prev"><</button>
			<span class="btn btn-secondary" id="current-date" style="font-weight: bold;"></span>
			<button type="button" class="btn btn-secondary" id="btn-next">></button>
		</div>
		<div style="margin:10px;">
			<div class="calendar"></div>
		</div>	
	</div>
	<script>
		let date = new Date();
		let curyear = date.getFullYear();
		let curmonth = date.getMonth()+1;
		let curday = date.getDate();
	</script>
</body>
</html>