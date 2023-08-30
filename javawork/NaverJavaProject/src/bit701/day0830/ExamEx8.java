package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//money 변수에 args[0] 값을 대입 후 (급여 백만단위 5674321)
		/*
		 * 출력
		 * money : 5674321 원
		 * 만원짜리 567장
		 * 천원짜리 4장
		 * 백원짜리 3개
		 * 십원짜리 2개
		 * 일원자리 1개
		 * 
		 * :산술연산자를 사용하여 출력하시오
		 */
		
				
		//출력1

//		String smoney= args[0];
//		int money=Integer.parseInt(smoney);
//		int money1=money/10000;
//		int money2=money/1000-money1*10;
//		int money3=money/100-money1*100-money2*10;
//		int money4=money/10-money1*1000-money2*100-money3*10;
//		int money5=money%10;
//		System.out.println("money : "+money+" 원");
//		System.out.println("만원짜리 "+money1+"장");
//		System.out.println("천원짜리 "+money2+"장");
//		System.out.println("백원짜리 "+money3+"장");
//		System.out.println("십원짜리 "+money4+"장");
//		System.out.println("십원짜리 "+money5+"장");
		
		
		//출력2
//		System.out.println("money : "+args[0]+" 원");
//		
//		String smoney= args[0];
//		int money=Integer.parseInt(smoney);
//		int money1=money/10000;
//		int money2=money%10000/1000;
//		int money3=money%1000/100;
//		int money4=money%100/10;
//		int money5=money%10;
//		System.out.println("money : "+money+" 원");
//		System.out.println("만원짜리 "+money1+"장");
//		System.out.println("천원짜리 "+money2+"장");
//		System.out.println("백원짜리 "+money3+"장");
//		System.out.println("십원짜리 "+money4+"장");
//		System.out.println("십원짜리 "+money5+"장");
		
		//출력3
		String smoney= args[0];
		int money=Integer.parseInt(smoney);
		System.out.println("money : "+money+" 원");
		System.out.println("만원짜리 "+money/10000+"장");
		System.out.println("천원짜리 "+money%10000/1000+"장");
		System.out.println("백원짜리 "+money%1000/100+"장");
		System.out.println("십원짜리 "+money%100/10+"장");
		System.out.println("십원짜리 "+money%10+"장");
		


	}

}
