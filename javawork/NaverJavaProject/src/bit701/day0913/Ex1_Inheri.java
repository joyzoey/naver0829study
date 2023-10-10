package bit701.day0913;

class SuperA
{
	public void process()
	{
		System.out.println("부모가 처리하는 process");
	}
}

//3개의 서브 클래스를 구현해보자
class SubA extends SuperA
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("그림을 그린다");
	}
}

class SubB extends SuperA
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("야구 게임을 한다");
	}
}

class SubC extends SuperA
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("테니스를 친다");

	}
}

public class Ex1_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//만약 서브 클래스로 선언시 3개의 일을 처리하려면 3번 선언
		SubA sub1=new SubA();
		sub1.process();
		
		SubB sub2=new SubB();
		sub2.process();
		
		SubC sub3=new SubC();
		sub3.process();
		System.out.println("========================");
		
		//선언을 한번만 하고 3가지 일을 처리하려면
		//부모로 선언하면 됨
		//부모로 선언시 그 변수에 누가 생성되어 있느냐에 따라서
		//똑같은 메소드를 호출하더라도 하는 일이 달라진다
		//이런식의 선언과 호출을 하는 방식을 다향성이라 한다
		//메소드를 만들 때도 3개가 아닌 한개만 만들어도 된다.
		SuperA sub4=null;
		sub4=new SubA();
		sub4.process();
		
		sub4=new SubB();
		sub4.process();
		
		sub4=new SubC();
		sub4.process();
		
		
	}

}