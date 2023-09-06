package bit701.day0906;

import java.util.Scanner;

public class Ex9_ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[]names= {"강호동","유재석","한채영","이효리","김나혜"};
		//이름을 검색하여 몇번째에 있는지 출력
		//없을 경우 "xxx님은 명단에 없습니다."
		
		Scanner sc=new Scanner(System.in);
		String name="";
		int find=-1;//찾을 경우 배열 인덱스 값 저장
		
		//검색할 이름 입력받고
		System.out.println("이름을 입력하세요.");
		name=sc.nextLine();

		
		//같은 이름이 있으면 find에 배열 인덱스 저장
		for(int i=0; i<names.length; i++) {
			if (name.equals(names[i])) {
				find=i;
				break;
			}
		}
				
		//find 값에 따라 메세지 출력
		if(find==-1) {
			System.out.println(name+"님은 명단에 없습니다.");
		}else {
			System.out.println(name+"님은 "+(find+1)+"번째에 있습니다.");
		}
		
		
	}

}
