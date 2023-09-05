package bit701.day0905;

import java.util.Scanner;

public class ex95_dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int n1=0;
		int n2=0;
		boolean run=true;
		
		while (run) {
			System.out.print("두 개의 주사위를 돌립니다.");
			String y=sc.nextLine();
			n1=(int)(Math.random()*6)+1;
			n2=(int)(Math.random()*6)+1;
			int sum=n1+n2;
			System.out.println(n1+","+n2);
			if (sum==5) {
				System.out.println("주사위 눈의 합이 5가 되었습니다.");
				System.out.println("프로그램을 종료합니다.");
				run=false;
			}
		}
		
		
	}

}
