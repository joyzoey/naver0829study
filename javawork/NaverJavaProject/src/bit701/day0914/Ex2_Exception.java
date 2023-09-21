package bit701.day0914;

import java.util.Scanner;

public class Ex2_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		while(true)
		{
			try {
				System.out.print("숫자1 입력:");
				int su1=Integer.parseInt(sc.nextLine());
				if(su1==00)
					break;
				System.out.print("숫자2 입력:");
				int su2=Integer.parseInt(sc.nextLine());
				int div=su1/su2;
				System.out.printf("%d 나누기 %d는 %d입니다\n",su1,su2,div);
				System.out.println();
			} catch (NumberFormatException e) {
				System.out.println("문자가 입력되었습니다 : "+e.getMessage());
			} catch (ArithmeticException e) {
				System.out.println("두번째 숫자는 0이 아닌 값으로 입력해주세요 :"+e.getMessage());
			} finally {
				//예외발생여부에 상관없이 무조건 실행되는 영역
				System.out.println("무조건 실행시킬 코드를 넣는 곳");
			}
			
		}System.out.println("정상종료.");
	}

}
