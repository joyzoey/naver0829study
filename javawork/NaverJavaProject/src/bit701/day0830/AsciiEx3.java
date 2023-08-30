package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//char, int 는 같은 타입이라고 봐도 된다 
		//왜냐면 아스키코드로 인식하기 때문에
		//근데 아스키코드 값으로 나옴
		char a1=65;
		int a2='b';
		
		System.out.println(a1);//A
		System.out.println((int)a1);//65
		System.out.println();
		
		System.out.println(a2);//98
		System.out.println((char)a2);//b
		System.out.println();
		
		System.out.printf("%d의 아스키문자는 %c이다\n",(int)a1,a2);
		System.out.println();
		
		char b1='C';
		int b2=68;
		
		System.out.println(b1);//C
		System.out.println(b2);//68
		System.out.println(b1+2);//묵시적 형변환, char+int=int, 즉69
		System.out.println((char)(b1+2));//강제 형변환, 즉E
		System.out.println();
		
		/* 묵시적 형변환(+는 연산을 의미)
		 * 	char   +  int    = int
		 * 	int    +  int    = int
		 *  long   +  int    = long
		 * 	double +  int    = double
		 * 	String +  int    = String
		 * 	String +  double = String
		 */
		
		System.out.println(5/2);//int+int=int,즉2
		System.out.println(5.0/2);//double+int=double,즉2.5
		System.out.println((double)5/2);//double+int=double,즉2.5
		System.out.println((double)(5/2));//int+int=int에서 결과를 double로 바뀜,즉 2.0

		/*
		 * print나 println은 모든타입 출력이 가능하다
		 * 이유는 타입별로 여러개를 같은 이름으로만들어놨기 때문
		 * 이런 메서드 중복함수(overloding method)라고 한다
		 */
	
	
	}

}
