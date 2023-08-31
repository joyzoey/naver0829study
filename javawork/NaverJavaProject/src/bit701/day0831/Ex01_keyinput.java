package bit701.day0831;

import java.util.Scanner;

public class Ex01_keyinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		//Static 변수나 메소드는 new로 객체 생성하지 않고 호출함
//		//대표적으로 Math 클래스의 모든 메서드는 static임
//		//static : 자바가 컴파일 되는 순간 가장 빠르게 정의되어 
//		//         별도의 객체 생성 없이 모든 객체와 공유가 가능		
//		System.out.println("3의 5승 = "+(int)Math.pow(3, 5));
//		System.out.println("5와 7중 큰 값은 = "+Math.max(5, 7));
		
		//new로 객체를 생성, 이 변수를 인스턴스 변수라고 함
		Scanner sc=new Scanner(System.in);
		
		System.out.print("당신의 나이를 입력하세요 : ");
		int age=sc.nextInt();
		System.out.println("당신은 "+age+"세 이군요.");
		
		//숫자 입력 후 문자열을 입력받는 경우 입력안되는 현상 발생함
		//숫자 입력 후 발생하는 엔터값이 버퍼에 저장되는데 
		//문자열 입력시 이 버퍼를 먼저 읽고 없을 경우 키보드로 읽기 때문
		
		//방법1 버퍼의 엔터문자를 먼저 읽어서 없앤다
		sc.nextLine();
		//방법2 숫자를 읽을 경우도 무조건 nextLine으로 문자열로 입력 후 변환하여 사용한다
		
		System.out.print("당신의 이름을 입력하세요 : ");
		String name=sc.nextLine();//한줄 전체를 읽어온다
		System.out.println("당신은 "+name+"님 이군요.");
	}

}
