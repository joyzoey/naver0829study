package bit701.day0831;

import java.util.Random;
import java.util.Scanner;

public class Ex97_rsp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * Q : 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
 		1. 사용자 / 컴퓨터가 임의의 가위, 바위, 보를 입력
     	- 사용자는 Scanner 를 사용하여 입력 (직접 가위, 바위, 보 중 하나 입력)
     	- 컴퓨터는 Random 를 사용하여 입력 (0, 1, 2 중 하나를 임의로 생성)
     	- Random 을 통해 생성된 0, 1, 2 의 값은 각각 가위, 바위, 보로 치환하여 동작하게 한다.

 		2. 승부 비교를 위한 조건문 작성
     	- 가위 : 바위 -> 바위 승, 가위 : 보 -> 가위 승, 가위 : 가위 -> 무승부
     	- 바위 : 바위 -> 무승부,  바위 : 보 -> 보 승,  바위 : 가위 -> 바위 승
     	- 보 : 바위 -> 보 승,    보 : 보 -> 무승부,   보 : 가위 -> 가위 승
   		 */
		
		Scanner sc=new Scanner(System.in);
		System.out.print("가위,바위,보 중 하나를 입력하세요 : ");
		String play2=sc.nextLine();

		System.out.println();
		System.out.println("당신이 낸 값은 "+play2+"입니다.");
		Random ran=new Random();
		int com1=ran.nextInt(3);
		String com2="";
		if (com1==0) {
			com2="가위";
		}else if (com1==1) {
			com2="바위";
		}else {
			com2="보";
		}
		System.out.println("컴퓨터가 낸 값은 "+com2+"입니다.");
		
		//숫자로 바꾼것
		int play1;
		if (play2.equals("가위")) {
			play1=0;
		}else if (play2.equals("바위")) {
			play1=1;
		}else if (play2.equals("보")) {
			play1=2;
		}else {
			play1=3;
		}
//		System.out.println(play1);
//		System.out.println(com1);

		
		//결과값만들기
		String result="";
		if (play1==com1) {
			result="무승부";
		} else if (play1==0 && com1==1) {
			result="패";
		} else if (play1==1 && com1==2) {
			result="패";
		} else if (play1==2 && com1==0) {
			result="패";
		} else if (play1==0 && com1==2) {
			result="승";
		} else if (play1==1 && com1==1) {
			result="승";
		} else if (play1==2 && com1==0) {
			result="승";
		} else { 
			result ="모름";
		}
		
		//결과출력
		System.out.println("결과는 "+result+"입니다.");


		
		}
		

	}


