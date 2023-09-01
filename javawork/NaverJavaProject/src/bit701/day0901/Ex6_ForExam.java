package bit701.day0901;

import java.util.Scanner;
public class Ex6_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 구구단 출력할 시작단 입력
		 * 4
		 * 구구단 출력할 끝단 입력
		 * 6
		 * 
		 * 4단  5단  6단     -단일 포문
		 * 쭈루 루루 루룩    -다중 포문
		 */

		Scanner sc=new Scanner(System.in);
		System.out.print("시작할 구구단 숫자를 입력하세요. : ");
		int n1=sc.nextInt();
		System.out.print("끝낼 구구단 숫자를 입력하세요. : ");
		int n2=sc.nextInt();

		//start가 end보다 클 경우 두 변수의 값 바꾸기
		if(n1>n2) {
			int temp=n1;
			n1=n2;
			n2=temp;
		}
				
		//제목출력
		for (int i=n1; i<=n2; i++) {
			System.out.printf("%10d단  ",i);
		}
		System.out.println();

		//구구단출력
		for(int i=1; i<=9;i++) {								//밑으로 진행 1-9로 올리기
			for(int j=n1;j<=n2;j++) {							//옆으로 진행 단수 올리기
				System.out.printf("%5d x %d = %2d",j,i,j*i);
			}
			System.out.println();
		}
		
	}
	
}
