package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex02_keyinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Date 클래스를 이용하여 현재 년도를 구해보자
		//(jdk1.1에서 deprecate 되었지만 여전히 많이 사용함)
		// Calendar를 권장한다고 함
		
		Date date=new Date();
		
		//getYear는 1900을 뺀 값이 반환됨
		int curYear=date.getYear()+1900;
		System.out.println("현재년도는"+curYear);
		
		Scanner sc=new Scanner(System.in);
		System.out.print("당신이 태어난 년도를 입력하세요 : ");
		
		//문자열로 읽은 후 숫자로 변환하면 다음에 문자열이 입력될 경우에도 문제발생x
		int birthYear=Integer.parseInt(sc.nextLine());
		
		System.out.print("지금 사는 곳을 입력하세요 : ");
		String address=sc.nextLine();
		
		
		//나이구하기
		int age=curYear-birthYear;
		
		System.out.println("당신은 "+address+"에 사는 "+birthYear+"년생 "+age+"세 학생이시군요.");
		System.out.printf("당신은 %s에 사는 %d년생 %d세 학생이시군요.",address,birthYear,age);
		System.out.println();

		
		//20세 이상이면 성인, 미만이면 미성년자 라는 글자를 출력
		
		//조건(삼항)연산자 가능 (조건식 참일때?  거짓일때 :)
//		String msg=age>=20?"성인":"미성년자";
//		System.out.println("당신은 "+msg+"입니다.");
		
		
		//if문
		String msg="";//지역변수는 자동 초기화x, 쓰레기값을 대비하여 초기값 지정을 권장
		if(age>=20) {
			msg="성인";
		}else {
			msg="미성년자";
		}
		System.out.println("당신은 "+msg+"입니다.");
		
	}

}
