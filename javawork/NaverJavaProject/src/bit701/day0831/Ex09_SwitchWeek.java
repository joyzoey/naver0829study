package bit701.day0831;

import java.util.Scanner;
public class Ex09_SwitchWeek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		//년도와 월을 입력하면 몇일까지 있는지 출력
		//해당 년도가 윤년인지 아닌지 판단
		System.out.print("년도 4자리 숫자 입력 : ");
		int year=sc.nextInt();
		System.out.print("월 입력 : ");
		int month=sc.nextInt();
		//잘못 월을 입력한 경우 종료
		if (month<1 || month>12) {
			System.out.println("월을 잘못 입력했어요.");
			return;
		}
		System.out.printf("입력한 년도와 월 %d년 %d월\n\n",year,month);
		int days=0;
		boolean b=year%4==0 && year%100!=0 || year%400==0;
		//if(b==true) systemout.println("윤년");
		if(b) System.out.println("윤년");//조건에서 t는 생략가능(f일 경우 !b)
		else System.out.println("평년");
		System.out.println();
		
		
		switch(month) {
		case 2:
			days=b?29:29;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
			break;
		default:
			days=31;
		}
		
		System.out.printf("%d년 %d월 %d일까지 있어요",year,month,days);
		}
		
	}


