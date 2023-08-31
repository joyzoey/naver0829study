package bit701.day0831;

import java.util.Scanner;

public class Ex08_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		
//		//숫자를 입력받아 영어로 출력
//		System.out.println("숫자를 입력하세요. : ");
//		
//		// switch는num값에 따라 해당 case실행
//		// break가 없는 경우 끝까지 실행됨
//		int num=sc.nextInt();
//		switch (num) {
//		case 1: 
//			System.out.println("one");
//			break;
//		case 2: 
//			System.out.println("two");
//			break;
//		case 3: 
//			System.out.println("three");
//			break;
//		default:
//			System.out.println("other number");
//		}	
		
			
		System.out.print("영문 색상명을 입력하세요. :");
		String color=sc.nextLine();
		
		switch (color) {
		case "red"://break가 없으므로 다음 case 실행
		case "RED":
			System.out.println(color+" : 빨강색");
			break;
		case "green":
		case "GREEN":
			System.out.println(color+" : 초록색");
			break;
		case "pink":
		case "PINK":
			System.out.println(color+" : 분홍색");
			break;
		default:
			System.out.println(color+" : 그 외의 색");
			
		}		
		
	}

}
