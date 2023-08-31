package bit701.day0831;

import java.util.Scanner;

public class Ex3_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		//점수를 입력받아서 1~100 아닐 경우 프로그램종료
		//90점 이상은 합격, 80이상 재시험, 나머지는 불합격
		
		System.out.print("점수를 입력하세요 : ");
		int score=sc.nextInt();
				
		//if문1
		if(score<1 || score>100) {
			
			System.out.println("잘못된 값 입력으로 종료합니다.");
			return;//return은 원래 해당 메서드만 종료하는 명령어임
					//메인메서드 종료는 곧 프로그램 종료를 의미
			
		}else if (score>=90) {
			
			System.out.println("합격입니다.");
			
		}else if (score>=80) {
			
			System.out.println("재시험입니다.");

		}else {
			
			System.out.println("불합격입니다.");
			
		}
		
		
		//조건
			if(score<1 || score>100) {
			
			System.out.println("잘못된 값 입력으로 종료합니다.");
			return;
			}
			String msg="";
			msg=score>=90?"합격":score>=80?"재시험":"불합격";
			System.out.println(msg+"입니다.");

	}
}
