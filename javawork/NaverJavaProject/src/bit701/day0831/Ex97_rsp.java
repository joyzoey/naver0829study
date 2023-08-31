package bit701.day0831;

import java.util.Random;
import java.util.Scanner;

public class Ex97_rsp {

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
		System.out.print("가위,바위,보 중 하나를 입력하세요 : ");
		Random ran=new Random();
		
		String[] choices = {"가위","바위","보"};
		

		
		
		
		
		
		
	}

}
