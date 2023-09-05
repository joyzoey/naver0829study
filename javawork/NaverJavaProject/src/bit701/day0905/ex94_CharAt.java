package bit701.day0905;

public class ex94_CharAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String snn="9506241230123";
		char sex=snn.charAt(6);
		switch (sex) {
			case '1':
			case '3':
				System.out.println("남자입니다.");
				break;
			case '2':
			case '4':
				System.out.println("여자입니다.");
				break;
		}
	}

}
