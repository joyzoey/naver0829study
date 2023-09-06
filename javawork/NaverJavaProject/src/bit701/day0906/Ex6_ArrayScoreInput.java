package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * score에 5개의 배열 할당
		 * 키보드로 직접 점수를 입력,배열에 저장
		 * 총점과 평균 구하기
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		System.out.println("다섯개의 점수를 입력하세요.");

		//변수 선언
		int []score=new int[5];
		int sum=0;
		double ave=0;
		
		//점수입력,총점계산
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1)+"번 점수 입력 : ");
			score[i]=sc.nextInt();
			
			//조건 추가:0-100사이 점수만 입력되게
			if (score[i]<0 || score[i]>100) {
				System.err.println("0-100사이 점수로 입력바람!");
				i=i-1;
				continue;
			}
			sum+=score[i];
		}
		
		//평균구하기
		ave=(double)sum/score.length;
				
		//출력
		System.out.print("\n입력한 점수들 : ");
		for(int n:score)
			System.out.printf("%4d",n);
		System.out.println("\n총점:"+sum);
		System.out.println("평균:"+ave);
		
	}

}
