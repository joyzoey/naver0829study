package bit701.day0906;

public class Ex17_p171 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1();
//		Ex17_p171.test1();//자기 자신안에 있는  static method
//		
		//배열 변수 선언
		int[]scores;
		
		//배열 변수에 배열대입
		scores = new int[] {83,90,87};
		
		//배열 항목의 총합을 구하고 출력
		int sum1=0;
		for(int i=0; i<3; i++) {
			sum1+=scores[i];
		}
		System.out.println("총합 : "+sum1);
		
		//배열을 매개값으로 주고 printItem 메소드 호출
		printItem(scores);
		
		System.out.println("=".repeat(30));
		printItem(new int[] {45,56,80,980,45});
	
	}	
//	public static void test1() {
//			System.out.println("test1메서드 호출");
//	}
	
	//printItem 메소드 선언
	public static void printItem(int []scores) {
		
		//매개변수가 참조하는 배열의 항목을 출력
		for(int i=0; i<scores.length;i++) {
			System.out.println("score["+i+"]:"+scores[i]);
		}
		
		
	}

}
