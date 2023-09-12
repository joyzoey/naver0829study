package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="red,blue,green,orange,gray";
		
		//문자열 분리 1
		String []strArray=str1.split(",");
		System.out.println("총 "+strArray.length+"개로 분리됨");
		for(int i=0;i<strArray.length; i++)
		{
			System.out.println(i+":"+strArray[i]);
		}
		System.out.println("=".repeat(20));
		
		//문자열 분리 케이스 2
		String str2="sea.jpg";
		String []str2Array=str2.split("\\.");//오류안남
		//String []str2Array=str2.split("[.]");//오류안남
		//String []str2Array=str2.split(".");//오류남
		System.out.println(str2Array.length);
		for(int i=0;i<str2Array.length; i++)
		{
			System.out.println(i+":"+str2Array[i]);
		}
		System.out.println("=".repeat(20));
	
		//문자열 분리 케이스 3번
		String str3="red|green|yellow";
		String []str3Array=str3.split("\\|");
		System.out.println(str3Array.length);
		for(int i=0;i<str3Array.length; i++)
		{
			System.out.println(i+":"+str3Array[i]);
		}
		System.out.println("=".repeat(20));
		
		//자바의 클래스를 이용해서 분리하기
		StringTokenizer st=new StringTokenizer(str1,",");
		System.out.println("총 "+st.countTokens()+"개로 분리");
		while(st.hasMoreTokens())//다음 분리할 토큰이 있으면 true.없으면 false
		{
			System.out.println(st.nextToken());
		}
		System.out.println("=".repeat(20));
		
		StringTokenizer st2=new StringTokenizer(str1,",");
		int count=st2.countTokens();
		for(int i=0; i<count;i++)
		{
			System.out.println(st2.nextToken());
		}

		

	}

}
