package bit701.day0905;

import java.util.Scanner;

public class ex93_CharAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String gender="";
		String con="";
		boolean run=true;
		
		while (run) {
			Scanner sc=new Scanner(System.in);
			System.out.println("주민번호를 [000000-0000000]와 같이 입력하시오.");
			String num=sc.nextLine();
			
			int lenth=num.length();
			
			if (lenth==14) {
				char test = num.charAt(7);
				
				switch (test) {
					case '1':
					case '3':
						gender="남자";
						con="내국인";
						break;
					case '2':
					case '4':
						gender="여자";
						con="내국인";
						break;
					case '5':
						gender="남자";
						con="외국인";
						break;		
					case '6':
						gender="여자";
						con="외국인";
						break;		
					default:
						System.out.println("입력한 주민번호를 다시 한번 확인해주세요.");
				}
				
				//System.out.printf("당신은 %s%s년 %s%s월 %s%s일생 ",num.charAt(0),num.charAt(1),num.charAt(2),num.charAt(3),num.charAt(4),num.charAt(5));
				System.out.printf("당신은 %s년 %s월 %s일생 ",num.substring(0,2),num.substring(2,4),num.substring(4,6));
				System.out.printf("%s %s입니다.",gender,con);
				run=false;
			
			}else {
				System.err.println("입력 양식이 맞지 않습니다.");
			}
			
	
			}
		
	}

}
