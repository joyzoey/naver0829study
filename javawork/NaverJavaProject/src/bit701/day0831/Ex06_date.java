package bit701.day0831;

import java.util.Date;
import java.util.Scanner;
public class Ex06_date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		//입력한 년월일에 해당하는 요일 구하기
		System.out.print("년,월,일을 순서대로 입력해주세요. : ");
		int year=sc.nextInt();
		int month=sc.nextInt();
		int day=sc.nextInt();
		
		//Date 클래스 생성
		Date date=new Date(year-1900,month-1,day);
		
		//요일구하기
		int weekint=date.getDay();//0일1월..
		//System.out.println("요일숫자: "+weekint);
		
		String week=weekint==0?"일":weekint==1?"월":
			weekint==2?"화":weekint==3?"수":weekint==4?"목":weekint==5?"금":"토";
		System.out.println("해당날짜는 "+week+"요일입니다.");
		
	}

}
