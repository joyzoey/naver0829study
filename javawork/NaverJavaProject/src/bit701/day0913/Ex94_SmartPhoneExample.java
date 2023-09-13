package bit701.day0913;

public class Ex94_SmartPhoneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//객체생성
		Ex95_SmartPhone myPhone=new Ex95_SmartPhone("갤럭시","은색");
		
		//상속받은 필드 읽기
		System.out.println("내 폰은 "+myPhone.color+myPhone.model);
		
		//원 필드 읽기
		System.out.println("와이파이 상태는 "+myPhone.wifi);
		
		//메소드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("누구세요");
		myPhone.sendVoice("뚱인데요");
		myPhone.receiveVoice("장난전화하지마라");
		myPhone.hangUp();
		
		myPhone.setWifi(true);
		myPhone.internet();
		
	}

}
