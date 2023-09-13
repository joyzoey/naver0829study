package bit701.day0913;


public class Ex98_Return {

	public static void main(String[] args) {
		Ex97_Car myCar=new Ex97_Car();
		
		myCar.setGas(5);
		
		if(myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		System.out.println("가스넣으세요");
		
	}

}
