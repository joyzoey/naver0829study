package bit701.day0918;
//자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를
//사용하는 익명 내부클래스의 또다른 표현식이다
//단 인터페이스는 단하나의 추상메서드만 가지고 있어야한다
@FunctionalInterface
interface Orange
{
	public void write();//추상메소드
	//public void show();//@Functional Interface는 메서드가 하나인지 아닌지 검증하는 역할, 오류발생
}
@FunctionalInterface
interface DataAdd
{
	public void add(int x, int y);
}


public class Ex4_Lambda {
	//우리가 알고있는 익명 내부클래스 형태로 객체 생성
	public void abstMethod1()
	{
		Orange or=new Orange() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("안녕하세욤ㅎ_ㅎ");
			}
		};
		or.write();
	}

	//람다식으로 오버라이드할 경우
	public void abstMethod2()
	{
		Orange or=()->System.out.println("방가워욤ㅋ_ㅋ");//메서드 코드가 한 줄 일경우 {}생략
		or.write();
		
		//메서드 코드가 2줄 이상일경우
		Orange or2=()->{
			System.out.println("람다");
			System.out.println("여러줄~");
		};
		or2.write();
	}
	
	public void abstMethod3()
	{
		DataAdd add1=(int x, int y)->System.out.println(x+"+"+y+"="+(x+y));
		
		add1.add(100, 200);
		add1.add(5, 7);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_Lambda ex=new Ex4_Lambda();
		ex.abstMethod1();
		ex.abstMethod2();
		ex.abstMethod3();

	}

}
