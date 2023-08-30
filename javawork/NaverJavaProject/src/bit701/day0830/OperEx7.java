package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//비교연산자 논리연산자,결과값은참거짓
		int kor=100, eng=90, mat=100;
		System.out.println(kor>=80);
		System.out.println(kor>=80||kor!=mat);
		System.out.println(kor<80||kor!=mat);
		System.out.println(kor>=80&&kor!=mat);
		System.out.println(kor<80||kor!=mat);
		System.out.println(!(kor==mat));
		System.out.println(kor>=95 && eng>=95 && mat>=95);//f
		System.out.println(kor>=95 && eng>=95 || mat>=95);//t
		System.out.println(kor>=95 || eng>=95 && mat>=95);//t
		
		int year=2023;
		System.out.println(year%4==0 && year%100!=0 || year%400==0);
		
		
	}

}
