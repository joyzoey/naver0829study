package bit701.day0905;

import java.util.Scanner;

public class ex97_money_p139_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int money=0;
		boolean run=true;
		
		Exit:
		while (run) {
			System.out.println("-------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------");
			System.out.print("선택> ");
			String num=sc.nextLine();
			System.out.println();
			
			//if 사용
//			if (num.equals("1")) {
//				System.out.print("예금액>");
//				money+=Integer.parseInt(sc.nextLine());
//			} else if (num.equals("2")) {
//				System.out.print("출금액>");
//				money-=Integer.parseInt(sc.nextLine());
//			} else if (num.equals("3")) {
//				System.out.println("잔고>"+money);
//			} else if (num.equals("4")) {
//				run=false;
//			} else {
//				System.out.println("다시 입력해주세요.");
//			}
			
			//switch 사용
			switch (num) {
				case "1":
					System.out.print("예금액>");
					money+=Integer.parseInt(sc.nextLine());
					break;
				case "2":
					System.out.print("출금액>");
					money-=Integer.parseInt(sc.nextLine());
					break;
				case "3":
					System.out.println("잔고>"+money);
					break;
				case "4":
					//run=false;
					//break;
					break Exit;
					
				default:
					System.out.println("다시 입력해주세요.");
					break;
			}
			
					
		}
		System.out.println("프로그램종료");
	}
}
