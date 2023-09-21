package bit701.day0914;

import java.util.Vector;

public class Ex13_List {

	public static void main(String[] args) {

		Vector<String> list1=new Vector<String>();//기본 10개 할당(10개씩 증가)
		System.out.println("list1 의 할당갯수:"+list1.capacity());
		
		Vector<String> list2=new Vector<String>(5);//기본 5개 할당(5개씩 증가)
		System.out.println("list2 의 할당갯수:"+list2.capacity());
		
		Vector<String> list3=new Vector<String>(3,2);//기본 3개할당(2개씩 증가)
		System.out.println("list3 의 할당갯수:"+list3.capacity());
		
		//객체 4개저장함=3개할당되었고 2개씩 증가이므로 방5,데이터4
		list3.add("red");
		list3.add("green");
		list3.add("blue");
		list3.add("pink");
		
		System.out.println("list3 의 할당갯수:"+list3.capacity());//방갯수
		System.out.println("list3 의 데이타갯수:"+list3.size());//데이터수
		

	}

}