package bit701.day0913;

public class Ex95_SmartPhone extends Ex96_Phone {

	//필드선언
	public boolean wifi;//기본값false
	
	//생성자선언
	public Ex95_SmartPhone(String model,String color) {
		this.model=model;
		this.color=color;
	}
	
	//매소드선언
	public void setWifi(boolean wifi) {
		this.wifi=wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
}
