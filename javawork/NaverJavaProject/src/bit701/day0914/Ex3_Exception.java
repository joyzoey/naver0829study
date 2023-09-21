package bit701.day0914;

import java.util.Date;
import java.util.Scanner;

public class Ex3_Exception {

	//호출하는 곳으로 예외처리를 던진다
	public static void dataInput() throws NumberFormatException, NullPointerException
	{
		Scanner sc=new Scanner(System.in);
		//Date date=null; NullpointException발생
		Date date=new Date();
		System.out.println("년도:"+(date.getYear()+1900));
		System.out.println("두개의 숫자를 입력하시오");
		int su1=Integer.parseInt(sc.nextLine());
		int su2=Integer.parseInt(sc.nextLine());
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dataInput();
		} 
		//예외처리
//			catch (NumberFormatException e) {
//			System.out.println("숫자로만 입력하세요:"+e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println("날짜 생성이 안되었습니다:"+e.getMessage());
//		}
		
		//두가지 예외 같이 처리할 경우
		catch(NumberFormatException|NullPointerException e) {
			System.out.println("날짜생성이 안됬거나 숫자입력:"+e.getMessage());
		}
		
		
		System.out.println("정상종료.");

	}

}
