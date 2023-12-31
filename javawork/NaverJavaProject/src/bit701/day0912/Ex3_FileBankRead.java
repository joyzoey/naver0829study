package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import bit701.day0911.Account;

public class Ex3_FileBankRead {
	public static final String BANK_FILE="D:\\naver0829/Bank.txt";
	Account []account=new Account[30];
	int count;
	
	public Ex3_FileBankRead() throws IOException {
		//파일에서 데이터를 읽어서 배열account에 넣기
		count=0;//초기값-데이터를 담을 배열 번지
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(BANK_FILE);
			br=new BufferedReader(fr);
			
			while(true)
			{
				String accountNo=br.readLine();
				if (accountNo==null)
					break;
				String accountName=br.readLine();
				int money=Integer.parseInt(br.readLine());
				
				//count 번지의 배열에 담는다
				account[count]=new Account(accountNo,accountName,money);
				count++;
			}
			System.out.println("총 "+count+"개의 계좌를 읽습니다.\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		}
		
	}
	public static void showTitle()
	{
		System.out.println();
		System.out.println("-".repeat(11));
		System.out.println(" 계좌 목록");
		System.out.println("-".repeat(11));
		System.out.println("계좌번호계좌명\t잔액");
		System.out.println("-".repeat(30));

	}
	public void accountList()
	{
		//일반 메서드에서는 static 메서드 호출이 가능
		//하지만 static 메서드에서는 일반 메서드 호출 불가능
		//같은 static만 호출 가능,this가 없기때문에
		showTitle();//제목출력
		for(int i=0; i<count; i++)
		{
			account[i].accountWrite();
		}
		System.out.println("-".repeat(30));
		System.out.println();
	}
	//계좌추가시 호출될 메서드
	public void addAccount(String accountNo,String accountName, int money)
	{
		if(count==account.length) {
			System.out.println("이미 계좌가 가득 채워졌습니다.삭제 후 다시 추가해주세요.");
			return;//메서드가 여기서 종료됨
		}
		//같은 계좌가 있는지 확인
		boolean find=false;
		for(int i=0; i<count; i++)
		{
			if(account[i].isAccount(accountNo)) {
				find=true;
				break;
			}
			
		}
		if(find)
			System.out.println("["+accountNo+"] 계좌는 이미 존재합니다.");
		else {
			account[count]=new Account(accountNo, accountName,money);
			count++;
			System.out.println("["+accountNo+"] 계좌를 추가하였습니다.");
		}
	}
	//종료시 배열의 내용을 파일에 저장할 메서드
	public void accountFileSave() throws IOException
	{
		FileWriter fw=null;
		fw=new FileWriter(BANK_FILE);
		for(int i=0;i<count;i++)
		{
			fw.write(account[i].getAccountNo()+"\n");
			fw.write(account[i].getAccountName()+"\n");
			fw.write(account[i].getMoney()+"\n");
		}
		System.out.println("배열의 계좌정보를 파일에 저장하였습니다.");
		fw.close();
	}
	
	//입금시 호출 될 메서드
	public void depositMoney(String accountNo, int money)
	{
		//같은 계좌번호를 찾아서 입금
		boolean find=false;
		for(int i=0; i<count; i++)
		{
			if (account[i].isAccount(accountNo))
			{
				find=true;
				account[i].addMoney(money);
				break;
			}
		}
		if(find)
			System.out.println("["+accountNo+"] 계좌에 "+money+"원이 입금되었습니다.");
		else
			System.out.println("["+accountNo+"] 계좌가 없습니다.");
	}
	//출금시 호출 될 메서드
	public void withdrawMoney(String accountNo, int money)
	{
		//같은 계좌번호를 찾아서 입금
				boolean find=false;
				for(int i=0; i<count; i++)
				{
					if (account[i].isAccount(accountNo))
					{
						find=true;
						account[i].subMoney(money);
						break;
					}
				}
				if(find)
					System.out.println("["+accountNo+"] 계좌에 "+money+"원이 출금되었습니다.");
				else
					System.out.println("["+accountNo+"] 계좌가 없습니다.");
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex3_FileBankRead ex=new Ex3_FileBankRead();
//		showTitle();//제목
//		ex.accountList();//계좌 목록 출력
		
		Scanner sc=new Scanner(System.in);
		Exit:
		while(true)
		{
			System.out.println("1.계좌추가 2.입금 3.출금 4.저장&종료");
			System.out.print("선택>");
			int num=Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1: {
				//추가할 계좌정보 입력
				System.out.print("추가할 계좌번호:");
				String accounNo=sc.nextLine();
				System.out.print("계좌주:");
				String accounName=sc.nextLine();
				System.out.print("초기입금액:");
				int money=Integer.parseInt(sc.nextLine());
				//추가할 메서드호출
				ex.addAccount(accounNo, accounName, money);
				//목록다시한번 호출
				ex.accountList();
				break;
			}
			case 2: {//입금
				System.out.print("입금할 계좌 번호:");
				String accounNo=sc.nextLine();
				System.out.print("입금액:");
				int money=Integer.parseInt(sc.nextLine());
				//입금처리할 멤버 메서드 호출
				ex.depositMoney(accounNo, money);
				//계좌 목록 출력
				ex.accountList();
				break;
			}
			case 3: {
				System.out.print("출금할 계좌 번호:");
				String accounNo=sc.nextLine();
				System.out.print("출금액:");
				int money=Integer.parseInt(sc.nextLine());
				//출금처리할 멤버 메서드 호출
				ex.withdrawMoney(accounNo, money);
				//계좌 목록 출력
				ex.accountList();
				break;
			}
			case 4: {
				ex.accountFileSave();//배열내용 파일에 저장
				System.out.println("파일 저장 후 종료합니다.");
				break Exit;//while문 빠져나가기
			}
			default:
				System.out.println("다시 입력해주세요");
			}//switch
		}//while
	}//main

}//class
