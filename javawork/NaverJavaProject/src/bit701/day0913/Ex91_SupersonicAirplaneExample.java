package bit701.day0913;

public class Ex91_SupersonicAirplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ex92_SupersonicAirplane sa= new Ex92_SupersonicAirplane();
		sa.takeoff();
		sa.fly();
		sa.flyMode=Ex92_SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode=Ex92_SupersonicAirplane.NORMAL;
		sa.fly();
		sa.land();
		
	}

}
