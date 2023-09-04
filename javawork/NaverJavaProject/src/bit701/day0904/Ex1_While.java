package bit701.day0904;

public class Ex1_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 반복문에는 for,while,do-while 3가지
		 * for는 주로 반복횟수가 정해져 있는 경우
		 * while과 do-while 은 반복횟수가 정해져있지 않은 경우
		 * 두가지 차이는 조건을 먼저주느냐, 나중에 주느냐(선조건,후조건)차이
		 */
		
		int a=65;//대문자 A 아스키코드값
		while(a<=90) {//조건이 참인 동안 실행 : 91이 되면 빠져나감
//			System.out.println((char)a);
//			a++;
			
			//위의 코드를 한줄로 줄여보세요.
			System.out.print((char)a++);
		}
		System.out.println();
		System.out.println("빠져나온 후 a값"+a);
		
		a=65;
		while(true) {
			System.out.print((char)a++);
			if(a>90) {
				break;
			}
		}
		System.out.println();
		System.out.println("빠져나온 후 a값"+a);

		a=65;
		do {
			System.out.print((char)a++);
			
		}while(a<=90);//조건 뒤에 반드시 ; 추가
		
		int n=10;
		while(n<10) {//조건이 거짓이면 한번도 반복안함
			System.out.print(n--);
		}
		System.out.println();

		
		//do_while은 무조건 일단 한번은 실행함
		do {
			System.out.print(n--);
			if(n==0) break;
		}while(n<10);
		System.out.println();
		
	}

}
