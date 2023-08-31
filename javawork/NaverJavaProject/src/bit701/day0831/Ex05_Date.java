package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex05_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//자바 사용- 날짜,시간 출력
		
		Date date=new Date();
		
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("현재년도 %d-%02d-%02d\n",year,month,day);
		System.out.printf("현재시간 %02d:%02d:%02d\n",hh,mm,ss);

		
		//Calendar 사용- 날짜,시간 출력
		//Calendar cal=new Calendar;//생성자가public이 아니라 오류
		
		Calendar cal=Calendar.getInstance();
		
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;//0-11이므로
		day=cal.get(Calendar.DATE);
		
		hh=cal.get(Calendar.HOUR);
		mm=cal.get(Calendar.MINUTE);
		ss=cal.get(Calendar.SECOND);
				
		System.out.printf("현재년도 %d-%02d-%02d\n",year,month,day);
		System.out.printf("현재시간 %02d:%02d:%02d\n",hh,mm,ss);

		//Cal 요일구하기
		int weekint=date.getDay();//0일1월..
		System.out.println("요일숫자: "+weekint);
		
		String week=weekint==0?"일":weekint==1?"월":
			weekint==2?"화":weekint==3?"수":weekint==4?"목":weekint==5?"금":"토";
		System.out.println("오늘은 "+week+"요일입니다.");
	}

}
