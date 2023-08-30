package bit701.day0830;

import java.util.Scanner;


public class SelfEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
		//369게임
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int num1=num/10;
		int num2=num%10;
		
		if((num1==3 || num1==6 || num1==9) && (num2==3 || num2==6 || num2==9)) {
			System.out.println("박수짝짝");}
			
			else if (num1==3 || num1==6 || num1==9 || num2==3 || num2==6 || num2==9) {
			System.out.println("박수짝");
				
		} else {
			System.out.println(" ");
		}
		}
		
	}


