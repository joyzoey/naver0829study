package bit701.day0830;

public class OperEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//증감연산자 : ++ 1씩증가, -- 1씩감소
		//변수 앞에 붙일 경우(전치) 1순위
		//변수 뒤에 붙일 경우(후치) 끝순위
		//단, 단항으로 사용할 경우 상관없음
		
		int a=5;
		int b=5;
		//단항으로 연산할 경우
		++a;
		b++;
		System.out.println(a);//6
		System.out.println(b);//6
		System.out.println(++a);// 증가 후 출력 7
		System.out.println(b++);// 출력 후 증가 6
		System.out.println(b);//위에서 증가한걸 출력 7
		System.out.println("a="+a+", b="+b);
		
		a=b=5;
		int m=++a;//증가 후 대입
		int n=b++;//대입 후 증가
		System.out.printf("a=%d,b=%d,m=%d,n=%d\n",a,b,m,n);//6,6,6,5
		
	}

}
