package bit701.day0901;

public class Ex4_BreakContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int a=1;a<=10;a++) {
			System.out.printf("%4d",a);
			if(a==5) break;//5출력 후 반복문 빠져나가기
		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		
		for (int a=1;a<=10;a++) {
			
			if(a%2==0) continue;//짝수일경우 출력하지 않고 다음 숫자로
			System.out.printf("%4d",a);

		}
		System.out.println();
		System.out.println("-".repeat(30));
		
		//다중포문에서 2개 반복문 한번에 빠져나가기
		Exit:
			for(int i=1;i<=3;i++) {
				System.out.println("i="+i);
				for(int j=1; j<=5;j++) {
					System.out.printf("%4d",j);
					if(j==3) break Exit;
				}
				System.out.println();
			}
		System.out.println("-".repeat(30));
		
	}

}
