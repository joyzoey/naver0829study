package bit701.day0906;

public class Ex14_ArrayStringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []names= {"한가인","강호동","강호남","Candy","손미나"};
		//selection sort-문자열 비교시
		for (int i=0; i<names.length-1; i++) 
		{
			for(int j=i+1; j<names.length;j++) 
			{
				//a.compareTo(b) :a가 b보다 클 경우 무조건 양수 값이 나옴
				if(names[i].compareTo(names[j])>0)//오름차순 부등호반대 내림차순
				{	
					String temp=names[i];
					names[i]=names[j];
					names[j]=temp;
				}
			}
		}
		for(String s:names)
			System.out.println(s);
	}

}
