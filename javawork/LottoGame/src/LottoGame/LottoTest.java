package LottoGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		//선언
		int money=0;
		int count = money/1000;//발행한로또갯수
		int []winCount = new int[count];//일치한갯수
		int []result = new int[5];//로또결과
		
		//null값채워주기
		for(int c=0; c<result.length; c++) {
			result[c] = 0;
		}
		List<Object> setLottoList = new ArrayList<Object>();//발행로또넣을 리스트
		
		//돈 넣기
		System.out.print("로또를 구입할 금액을 입력하세요:");
		try {
			money=Integer.parseInt(sc.nextLine());
			if (money<1000) { //금액이 1000원 미만일때
				System.out.println("[ERROR] 금액이 부족합니다.");
				return; //돌아가기 
			}
			if (money%1000!=0) {//금액이1000원단위 아닐때
				System.out.println("[ERROR] 금액이 나누어떨어지지않습니다.");
				return; //돌아가기
			}
			
			System.out.println("\n["+count+"개의 로또를 구매했습니다.]");
			
			
			//당첨번호입력하기
			System.out.print("\n당첨 번호 6개를 다음 양식으로 입력해주세요\n0,0,0,0,0,0:");
			String line=sc.nextLine();//라인으로 받아서
			String []winArray=line.split(",");//나누기
			Set<Integer> winLotto=new TreeSet<Integer>();//set으로 받아서 중복없애기
			for(int i=0; i<winArray.length; i++)
			{
				int j=Integer.parseInt(winArray[i]);
				if(j<0||j>45) { //로또번호 범위벗어날때
					System.out.println("[ERROR] 로또번호는 1부터 45사이의 숫자여야합니다.");
					return;//돌아가기
				}
				winLotto.add(j);//나눈값 넣어주기
			}
			if(winLotto.size()!=6) {//리스트 객체값이 6이 아닐때
				System.out.println("[ERROR] 양식이 맞지 않습니다.");
				return;//돌아가기
			}
			
			//보너스번호입력하기
			System.out.print("보너스 번호를 입력해주세요:");
			int bonus=Integer.parseInt(sc.nextLine());

			//로또발행
			for (int i=0; i<count; i++)//로또갯수만큼포문
			{
				winCount[i] = 0;
				Set<Integer> setLotto=new TreeSet<Integer>();//샛컬렉션활용
				
				while(true)//로또안에난수입력
				{
					int n=(int)(Math.random()*45)+1;//난수생성 
					setLotto.add(n);//난수입력
					
					if(setLotto.size()==6) {
						break;//종료
					}
				}
				//로또일치비교
				for(Integer q : setLotto) {
					for(Integer j : winLotto) {
						if(q == j) {
							winCount[i] = winCount[i] + 1;
						}
					}
				}
				//어디서 카운트 올라가는지 확인한것
//				for(Integer j : winLotto) {
//				System.out.println(i + " j : " + j + " n : " + n);
//				if(j == n) {
//					System.out.println("in if : " + i + " j : " + j + " n : " + n);
//					winCount[i] = winCount[i] + 1;
//				}
//			}
				//로또결과스위치문
				switch(winCount[i]) {
					case 3: //3개 일치
						result[0] = result[0] + 1;
						break;
					case 4://4개 일치
						result[1] = result[1] + 1;
						break;
					case 5://5개 일치
						boolean bonusFlag = false;
						
						for(Integer j : setLotto) { //보너스볼 확인
							if(j == bonus) {
								bonusFlag = true;
							}
						}
						
						if(bonusFlag) {
							result[2] = result[2] + 1;
						} else {
							result[3] = result[3] + 1;
						}
						break;
					case 6://6개 일치
						result[4] = result[4] + 1;
						break;
				}
				
				//로또 리스트에 저장하기
				setLottoList.add(setLotto);
				
			}
			//발행로또 출력
			for(int i=0; i<setLottoList.size(); i++) {
				System.out.println((i+1) + " : " + setLottoList.get(i) + " 일치갯수 : " + winCount[i]);
			}
			//결과 출력
			System.out.println("\n[당첨결과]");
			System.out.println("3개 일치 (5,000원) - " + result[0] + " 개");
			System.out.println("4개 일치 (50,000원) - " + result[1] + " 개");
			System.out.println("5개 일치 (1,500,000원) - " + result[2] + " 개");
			System.out.println("5개 일치, 보너스 볼 (30,000,000원) - " + result[3] + " 개");
			System.out.println("6개 일치 (2,000,000,000원) - " + result[4] + " 개");
			
			//수익률출력
			long totalRes = (result[0]*5000) + (result[1]*50000) + (result[2]*1500000) +(result[3]*30000000)+(result[4]*2000000000);
			System.out.println("\n[수익금]\n"+totalRes+"원");
			
			
			
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 숫자가 아닙니다.");
		}
				
	}
}
