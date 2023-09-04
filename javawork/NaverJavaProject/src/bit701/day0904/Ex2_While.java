package bit701.day0904;

import java.util.Scanner;

public class Ex2_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//정수를 입력받아 총점과 평균을 구해보자
		//0입력시 정수 입력 종료
		Scanner sc=new Scanner(System.in);
		int score;
		int sum=0, count=0;
		double avg=0;
		while(true) {
			System.out.println("점수를 입력하세요.");
			score=sc.nextInt();
			if(score==0) break;//0입력시 빠져나가기
			if(score<1 || score>100) {
				System.out.println("1~100사이의 정수만 입력해주세요.");
				continue;//하던 작업 중단하고 다시 처음으로 돌아감
			}
			count++;//입력한갯수
			sum+=score;//총점
		}
		avg=(double)sum/count;
		System.out.println("입력된 점수는 "+count+"개이고, ");
		System.out.println("총 합계는 "+sum+"이며,");
		System.out.println("평균은 "+avg+"입니다");
	}

}
