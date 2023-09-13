package bit701.day0913;

public class Ex92_SupersonicAirplane extends Ex93_Airplane {

	//상수선언
	public static final int NORMAL=1;
	public static final int SUPERSONIC=2;
	//상태필드선언
	public int flyMode = NORMAL;
	
	//메소드재정의
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if(flyMode==SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		}else {
		//airplane 객체의 fly메소드 호출
		super.fly();
		}
	}
	
}
