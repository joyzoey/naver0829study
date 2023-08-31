package bit701.day0831;

public class Ex98_quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//for문으로 별이 늘어나는 코드 작성
		int i,j;
		for(i=0; i<5; i++) {
			for(j=0; j<i; j++){
				System.out.print("*");
			}
			System.out.println("*");
		}
	}

}
