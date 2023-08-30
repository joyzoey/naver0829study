package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//매개변수실습
		System.out.println("내이름은 "+args[0]+" 입니다.");
		System.out.println("우리집은 "+args[1]+" 입니다.");
		System.out.println("혈액형은 "+args[2]+" 형입니다.");
		System.out.println();

		//실수형 데이터 타입 실습
		float f1=1234.567891234f;//4바이트 float으로 값을 지정하려면 f추가해야함
		double f2=1234.567891234;
		System.out.println(f1);//8자리까지 정확히 출력
		System.out.println(f2);//15자리까지 정확히 출력
		System.out.println();
		
		//char실습
		char ch1='b';
		char ch2='가';//char 타입은 2바이트 한글도 저장가능
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println();
	
	}

}
