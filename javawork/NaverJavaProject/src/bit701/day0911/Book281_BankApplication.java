package bit701.day0911;

import java.util.Scanner;

public class Book281_BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account []account=new Account[10];
		Scanner sc=new Scanner(System.in);
		//배열 10개가 꽉 차면 더이상 계좌생성x
		int idx=0;
		
		Exit:
		while(true)
		{
			System.out.println("-".repeat(50));
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-".repeat(50));
			System.out.print("선택> ");
			String num=sc.nextLine();
			System.out.println();
			
			//switch 사용
			switch (num) {
				case "1":
					if(idx>=10) {
						System.out.println("**더이상 계좌생성이 안됩니다.**");
						break;
					}
					System.out.println("-".repeat(10));
					System.out.println("계좌생성");
					System.out.println("-".repeat(10));
					System.out.print("계좌번호(xxx-xxx)>");
					String accountNo=sc.nextLine();
					System.out.print("계좌주>");
					String accountName=sc.nextLine();
					System.out.print("초기입금액>");
					int money=Integer.parseInt(sc.nextLine());
					
					account[idx]=new Account (accountNo, accountName, money);
					System.out.println("결과 : 계좌가 생성되었습니다.");
					idx++;
					break;
				case "2":
					System.out.println("-".repeat(10));
					System.out.println("계좌목록");
					System.out.println("-".repeat(10));
					for(int i=0; i<idx; i++)
					{
						account[i].accountWrite();
					}
					break;
				case "3":
					System.out.println("-".repeat(10));
					System.out.println("예금");
					System.out.println("-".repeat(10));
					System.out.print("계좌번호(xxx-xxx)>");
					accountNo=sc.nextLine();
					System.out.print("예금액>");
					money=Integer.parseInt(sc.nextLine());
					//계좌번호 찾은 후 그 배열번지의 money에 추가
					for(int i=0; i<idx; i++)
					{
						if(account[i].isAccount(accountNo)) {
							account[i].addMoney(money);
							break;
						}
					}
					System.out.println("결과:예금이 성공되었습니다.");
					break;
				case "4":
					System.out.println("-".repeat(10));
					System.out.println("출금");
					System.out.println("-".repeat(10));
					System.out.print("계좌번호(xxx-xxx)>");
					accountNo=sc.nextLine();
					System.out.print("출금액>");
					money=Integer.parseInt(sc.nextLine());
					//계좌번호 찾은 후 그 배열번지의 money에 빼기
					for(int i=0; i<idx; i++)
					{
						if(account[i].isAccount(accountNo)) {
							account[i].subMoney(money);
							break;
						}
					}
					System.out.println("결과:출금이 성공되었습니다.");
					break;
				case "5":
					break Exit;
				default:
					System.out.println("다시 입력해주세요.");
					break;	
				
			
			}

		}System.out.println("프로그램종료");
	}
}
