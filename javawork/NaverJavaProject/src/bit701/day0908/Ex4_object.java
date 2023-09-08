package bit701.day0908;

import java.net.MulticastSocket;

public class Ex4_object {
	
	//인스턴스 멤버변수
	private int score;
	//클래스 멤버변수
	static public String message;

	//인스턴스 멤버 메서드
	//score 에 값을 넣는 메서드 setter method
	public void setScore(int score)
	{
		//멤버변수 score에 인자로 받은 score를 전달
		//매개변수명이 멤버변수명이랑 같은 경우 멤버변수앞에 this
		this.score=score;
	}
	
	//점수를 반환하는 getter method
	public int getScore()
	{
		return score;//this.score에서 this 생략 가능
	}
	
	//static 메서드는 static 멤버변수만 접근가능
	public static void setMessage(String message)
	{
		Ex4_object.message=message;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//main메서드는 static이므로 new로 생성을 해야 
		//멤버 접근이 가능하다
		//단 static은 호출 가능
		
		Ex4_object.setMessage("Hello World!!");
		//public 이므로 바로 출력가능
		System.out.println(Ex4_object.message);
		
		Ex4_object ex4=new Ex4_object();
		ex4.setScore(89);
		System.out.println("점수:"+ex4.getScore());
		
	}

}
