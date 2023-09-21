package bit701.day0919;

//인터페이스가 함수형으로 구현이 가능한지 검증
@FunctionalInterface
interface Calculable{
	//추상메서드
	public void calculate(int x, int y);
}


public class Ex01_Book697_Lambda {

	public static void action(Calculable calculable)
	{
		int x=10;
		int y=4;
		//데이타처리
		calculable.calculate(x, y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		action((x,y)->{
			int result=x+y;
			System.out.println("add result="+result);
		});
		action((x,y)->{
			int result=x-y;
			System.out.println("sub result="+result);
		});

		
	}
}
	
