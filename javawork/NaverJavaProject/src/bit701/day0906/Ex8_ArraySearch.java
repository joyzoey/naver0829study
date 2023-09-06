package bit701.day0906;

import java.util.Scanner;

public class Ex8_ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[]names= {"강호동","유재석","한채영","이효리","김나혜"};
		//이름을 검색하여 몇번째에 있는지 출력
		//없을 경우 "xxx님은 명단에 없습니다."
		
		Scanner sc=new Scanner(System.in);
		String name="";
		boolean bFind=false;
		
		
		//검색할 이름 입력받고
		System.out.println("이름을 입력하세요.");
		name=sc.nextLine();

		
		//for문 같은 이름이 있을 경우 출력,bFind true/break
		for(int i=0; i<names.length; i++) {
			if (name.equals(names[i])) {
				bFind=true;
				System.out.println(name+"님은 "+(i+1)+"번째에 있습니다.");
				break;
			}
					
		}
				
		//못찾은 경우 못찾았다고 출력
		if(!bFind) {
			System.out.println(name+"님은 명단에 없습니다.");
		}
		
		
	}

}
