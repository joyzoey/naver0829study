package bit701.day0906;

import java.util.Random;
import java.util.Scanner;
public class Ex99_todayquiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*
		 * Q : 가위바위보 게임 -> 사용자 입력으로 사용자가 가위 또는 바위 또는 보를 입력하는 것만으로 동작.
 		1. 사용자 / 컴퓨터가 임의의 가위, 바위, 보를 입력
     	- 사용자는 Scanner 를 사용하여 입력 (직접 가위, 바위, 보 중 하나 입력)
     	- 컴퓨터는 Random 를 사용하여 입력 (0, 1, 2 중 하나를 임의로 생성)
     	- Random 을 통해 생성된 0, 1, 2 의 값은 각각 가위, 바위, 보로 치환하여 동작하게 한다.

 		2. 승부 비교를 위한 조건문 작성
     	- 가위 : 바위 -> 바위 승, 가위 : 보 -> 가위 승, 가위 : 가위 -> 무승부
     	- 바위 : 바위 -> 무승부,  바위 : 보 -> 보 승,  바위 : 가위 -> 바위 승
     	- 보 : 바위 -> 보 승,    보 : 보 -> 무승부,   보 : 가위 -> 가위 승
   		
   		3. 2번 비교 결과에 따른 승, 패, 무 저장해두어 승률을 출력
   		 */
		
		Scanner sc=new Scanner(System.in);
		String player="";
		int [] score=new int[3];
		boolean run=false;
		
		while (true) {
			
			while (true) {
				System.out.print("가위,바위,보,종료 중 하나를 입력하세요 : ");
				player=sc.nextLine();
				if(player.equals("가위") || player.equals("바위") || player.equals("보") || player.equals("종료")) {
					if(player.equals("종료")) {
						run=true;
					} break;
				} else {
					System.out.println("잘못입력하였습니다.\n");
				}	
			}
			
			if(run) {
				break;
			}
			
			//컴터값 랜덤
			Random ran=new Random();
			int com1=ran.nextInt(3);
			
			//컴터값 변환
			String com2="";
			if (com1==0) {
				com2="가위";
			}else if (com1==1) {
				com2="바위";
			}else {
				com2="보";
			}
			
			//승패연산
			String result="";
			if (player.equals(com2)) {
				result="무승부";
				score[2]++;
			} else if (player.equals("가위") && com2.equals("바위")) {
				result="패";
				score[1]++;
			} else if (player.equals("바위") && com2.equals("보")) {
				result="패";
				score[1]++;
			} else if (player.equals("보") && com2.equals("가위")) {
				result="패";
				score[1]++;
			} else if (player.equals("가위") && com2.equals("보")) {
				result="승";
				score[0]++;
			} else if (player.equals("바위") && com2.equals("가위")) {
				result="승";
				score[0]++;
			} else if (player.equals("보") && com2.equals("바위")) {
				result="승";
				score[0]++;
			} else { 
				result ="모름";
			}
			
			//결과출력
			System.out.println("\t당 신 : "+player);
			System.out.println("\t컴 터 : "+com2);
			System.out.println("\t결 과 : "+result);
			System.out.println("\t[현재 스코어] "+score[0]+"승 "+score[1]+"패 "+score[2]+"무\n");

		}
		
	}
}