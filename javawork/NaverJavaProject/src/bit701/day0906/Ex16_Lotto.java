package bit701.day0906;

import java.util.Random;
public class Ex16_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 6개가 할당된 lotto 변수에 1~45사이의 난수
		 * 중복되지 않은 수를 오름차순정렬로 출력
		 */
		
		//선언
		Random r=new Random();
		int []lotto=new int[6];
		//난수
		for (int i=0; i<lotto.length; i++) {
			lotto[i]=r.nextInt(45)+1;
			for(int j=0; j<i; j++) {
				//중복
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		//오름차순 정렬
		for (int i=0; i<lotto.length-1; i++) {
			for (int j=i+1; j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		//출력
		for (int i=0; i<lotto.length; i++) {
			System.out.printf("%3d",lotto[i]);
		}
		
	}

}
