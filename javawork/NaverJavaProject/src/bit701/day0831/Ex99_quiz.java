package bit701.day0831;

public class Ex99_quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//1-100까지 정수 중 3의 배수 총합 출력
		int sum=0;
		int i=1;
		for(i=1; i<=100; i++) {
			if (i%3==0) {
				sum += i;
				continue;
			}
		}
		System.out.println(sum);//1683

	}

}
