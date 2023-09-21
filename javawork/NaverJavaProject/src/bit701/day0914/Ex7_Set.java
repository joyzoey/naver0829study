package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {

	public static void main(String[] args) {
		//set 인터페이스의 특징
		/*
		 * 1.순차적이 아니다
		 * 2.중복허용을 안한다
		 */
		
		//셋 컬렉션 생성
		//Set<Integer> set=new HashSet<Integer>();//비순차적
		Set<Integer> set=new TreeSet<Integer>();//오름차순정렬
		
		//저장된 객체수 확인 (배열은 length, 컬렉션은 size)
		System.out.println(set.size());//size는 데이타의 갯수
		
		//객체 저장
		set.add(15);
		set.add(30);
		set.add(89);
		set.add(2);
		set.add(105);
		set.add(67);
		set.add(94);
		set.add(5);
		set.add(10);
		set.add(6);
		set.add(7);
		set.add(8);
		
		//저장된 객체수 확인
		System.out.println(set.size());//3;  5는 1번만 계산
	
		//출력1
		System.out.println("========================");
		for(Integer n:set)
			System.out.println(n);
		System.out.println("========================");
		
		//출력2
		Iterator<Integer> iter=set.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
	}

}
