package bit701.day0901;

public class Ex3_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int a=1;a<10;a++) {
//			System.out.println("a="+a);
//		}
//		System.out.println("=".repeat(30));//"="을 30번 반복
//		
//		for (int a=1;a<=10;a++)
//			System.out.printf("%4d",a);
//		System.out.println();
//		System.out.println("=".repeat(30));//"="을 30번 반복
//		
//		for (int a=1;a<=20;a+=3)
//			System.out.printf("%4d",a);
//		System.out.println();
//		System.out.println("=".repeat(30));//"="을 30번 반복
		
		//다중 for
		for(int i=1; i<=3; i++) {
			System.out.println("i="+i);
			for(int j=1; j<=5; j++) {
				System.out.printf("%3d",j);
				
			}
			System.out.println();
		}
		System.out.println("=".repeat(30));//"="을 30번 반복

		
	}

}
