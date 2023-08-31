package bit701.day0831;

import java.util.Scanner;
import java.text.NumberFormat;
public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 상품명과 수량, 단가를 받아 총금액 출력
		 * 수량이 5개 이상일 경우 10프로 할인된 최종 금액 출력
		 * 
		 * 출력예
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가(원) : 1000
		 * 
		 * 총 금액(원) : 6000
		 * 최종 금액(원) : 5400
		 */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("상품명 : ");
		String name=sc.nextLine();
		System.out.print("수량 : ");
		int num=Integer.parseInt(sc.nextLine());
		System.out.print("단가(원) : ");
		int price=Integer.parseInt(sc.nextLine());
		System.out.println("");
		
		
		double discount;
		if (num>=5) {
			discount=num*price*0.9;
			System.out.println("수량이 5개 이상이라 10% 할인되었습니다.");
		}else {
			discount=num*price;
		}
		
		NumberFormat form=NumberFormat.getInstance();
		System.out.println("총 금액(원) : "+form.format(num*price));
		System.out.println("최종 금액(원) : "+form.format((int)discount));
		
		


	}

}
