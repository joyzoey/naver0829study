package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []com=new int[3];
		int []user=new int[3];
		String strNum;
		Scanner sc=new Scanner(System.in);
		int ball, strike;
		
		//1-9사이 중복되지 않은 숫자를 배열에 담는다
		for (int i=0; i<com.length; i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		//System.out.printf("%d%d%d",com[0],com[1],com[2]);
		//System.out.println();
		
		while (true)
		{
			System.out.print(">>");
			strNum=sc.nextLine();
			//strNum의 각 숫자를 user 배열에 정수형태로 넣기
			user[0]=strNum.charAt(0)-'0';//'1'은 정수로 49
			user[1]=strNum.charAt(1)-'0';//'1'-'0'=1(49-48)
			user[2]=strNum.charAt(2)-'0';
			//System.out.printf("%d,%d,%d\n",user[0],user[1],user[2]);
			
			//user와 com을 비교하여 숫자가 잇지만 자리수가 안맞을 경우 ball을 증가
			//자리수까지 맞을 경우 strkie 증가
			//strike이 3일때 정답 "축하합니다.정답입니다" 출력종료
			ball=0;
			strike=0;
			
			for(int i=0; i<3; i++)
			{
				for (int j=0; j<3; j++)
				{
					if(com[i]==user[j])
					{
						if(i==j)
							strike++;
						else
							ball++;
						
					}
				}
			}
			System.out.println("ball : "+ball);
			System.out.println("strike : "+strike);
			
			if(strike==3)
			{
				System.out.println("축하합니다. 정답입니다.");
				break;
			}
			//종료
			if(strNum.equalsIgnoreCase("q")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		
		
	}

}
