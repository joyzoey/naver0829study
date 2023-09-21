package bit701.day0914;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex9_SetLotto {

	public static void main(String[] args) {
		//금액을 입력하면 그 금액만큼 로또 숫자 출력하기
		
		Scanner sc=new Scanner(System.in);
		
		int money;
		
		System.out.print("로또를 구입할 금액을 입력하세요:");
		//문자입력시 예외처리
		try {
			//금액 입력받기
			money=Integer.parseInt(sc.nextLine());
			//최소금액 에러
			if(money<1000) {
				System.out.println("금액이 부족합니다");
				return;
			}
			//배열 길이 구하는 포문
			for (int i=1; i<=money/1000; i++)
			{
				//셋 컬랙션 생성
				Set<Integer> setLotto=new TreeSet<Integer>();
				//로또번호 : 6개 난수 (1-45)
				while(true)
				{
					int n=(int)(Math.random()*45)+1;//난수생성
					setLotto.add(n);//난수입력
					if(setLotto.size()==6)
						break;
				}
				//출력
				System.out.printf("%2d:",i);//순서
				for(Integer n:setLotto)
				{
					System.out.printf("%3d",n);//로또출력
				}
				System.out.println();
			}
		}catch (NumberFormatException e) {
			System.out.println("금액은 숫자로 입력해주세요:"+e.getMessage());
		}
	}

}
