package bit701.day0901;

import java.util.Scanner;
import java.text.NumberFormat;

public class Ex2_Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 이름 3과목의 점수를 입력 받아 총점과 평균, 소수점 1자리 출력(numberFormat)
		 * 등급 출력(grade:평균 90이상일때 "Excellent" 80 "Good" 나머지 "Try"
		 */
		
		//선언
		Scanner sc=new Scanner(System.in);
		NumberFormat numForm=NumberFormat.getInstance();
		numForm.setMaximumFractionDigits(1);
		String name="";
		int kor=0, eng=0, mat=0, total=0;
		double aver=0;
		String grade="";
		
		//입력
		System.out.print("당신의 이름을 입력하세요. : ");
		name=sc.nextLine();
		System.out.print("국어 점수를 입력하세요. : ");
		kor=sc.nextInt();
		System.out.print("수학 점수를 입력하세요. : ");
		mat=sc.nextInt();
		System.out.print("영어 점수를 입력하세요. : ");
		eng=sc.nextInt();

		//계산
		total=kor+mat+eng;
		aver=(double)total/3;
			//System.out.println(aver);
		
		//조건
		if(aver>=90) grade="Excellent";
		else if(aver>=80) grade="Good";
		else grade="Try";
		
		//출력
		System.out.println();
		System.out.println("세 과목의 총점은 "+total+"점이고 평균은 "+numForm.format(aver)+"점입니다.");
		System.out.printf("따라서 당신의 등급은 %s 입니다.",grade);
	
	}

}
