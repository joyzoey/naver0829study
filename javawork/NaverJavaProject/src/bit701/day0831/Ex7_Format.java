package bit701.day0831;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Ex7_Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//패턴이용 날짜,시간 출력
		Date date=new Date();
		
		//패턴1 2023-08-31 14:58:35 목
		SimpleDateFormat form1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		System.out.println(form1.format(date));
		
		//패턴2 2023년 08월 31일 오후 02:59:03 목요일
		SimpleDateFormat form2=new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEEE");
		System.out.println(form2.format(date));
		
		//숫자를 포멧양식에 맞게 출력
		int money=4567890;
		NumberFormat form3=NumberFormat.getInstance();
		System.out.println(form3.format(money));//4,567,890
		
		NumberFormat form4=NumberFormat.getCurrencyInstance();//지역설정화폐단위
		System.out.println(form4.format(money));
		
		double num=456.12345;
		System.out.println(form3.format(num));//456.123
		
		form3.setMaximumFractionDigits(1);
		System.out.println(form3.format(num));//456.1
		
	}

}
