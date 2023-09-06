package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 4명의 이름과 점수를 입력하면
		 * 이름과 점수 등수를 출력하는 프로그램작성
		 * 단,점수가 0-100을 벗어날 경우 다시 입력
		 */
		
		Scanner sc=new Scanner(System.in);
		System.out.println("4명의 점수를 입력하세요.");

		//변수 선언
		int []score=new int[4];
		int []rank=new int[4];
		String []name=new String[4];
		
		// 입력
		for(int i=0; i<name.length;i++) {
			System.out.print((i+1)+"번 이름 입력 : ");
			name[i]=sc.nextLine();
			System.out.print((i+1)+"번 점수 입력 : ");
			score[i]=Integer.parseInt(sc.nextLine());
			if (score[i]<0 || score[i]>100) {
				System.err.println("0-100사이 점수로 입력바람!");
				i--;
				continue;
			}			
		}
		// 등수
		for(int i=0;i<score.length; i++) {
			rank[i]=1;
			for(int j=0;j<score.length;j++) {
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}
		// 출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(50));
		for (int i=0;i<score.length;i++) {
			System.out.println(i+1+"\t"+name[i]+"\t"+score[i]+"\t"+rank[i]);
		}

		


		
		
		
	}

}
