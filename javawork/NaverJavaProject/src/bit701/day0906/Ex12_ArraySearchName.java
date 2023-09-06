package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[]names= {"강호동","유재석","한채영","이효리","이승기","강남길","이민정","이서진","손미나","유미리"};
		//System.out.println(names.length);//10

		/*
		 * 검색할 성은? 이
		 * 			4:이효리
		 * 				...
		 * 			총 4명
		 * 
		 * 검색할 성은 박
		 * 			박씨 성을 가진 멤버는 없습니다.
		 * 
		 * 검색할 성은? 끝
		 * 			종료합니다.
		 * 
		 * 변수 : String searchSung
		 * 			int count;
		 * 			boolean bFind;
		 * 
		 * startsWith 이용
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
				
		String searchSung="";
		int count=0;
		boolean bFind=false;
		
		while(true) {
			count=0;
			bFind=false;
			
			System.out.print("검색할 성은?");	
			searchSung=sc.nextLine();
			//종료
			if(searchSung.equals("끝")) {
				System.out.println("\n***** 종료합니다.*****");
				break;
			}
				
			for (int i=0; i<names.length; i++) {
				if (names[i].startsWith(searchSung)) {
					System.out.println("\t"+(i+1)+" : "+names[i]);
					count++;
					bFind=true;
								
				} 
			}
			if (!bFind) { 
				System.out.println(searchSung+"씨 성을 가진 멤버는 없습니다.\n");	
			}
			else System.out.println("\t총 "+count+"명\n");
		}
	}
		
		
		
}


