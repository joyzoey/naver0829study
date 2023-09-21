package bit701.day0914;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex8_Set {

	public static void main(String[] args) {
		//컬렉션생성
		//Set<String> set=new HashSet<String>();//정렬x
		Set<String> set=new TreeSet<String>();//순서대로
		//객체저장
		set. add("red");
		set. add("blue");
		set. add("red");
		set. add("yellow");
		set. add("green");
		set. add("red");
		set. add("biolet");
		set. add("blue");
		set. add("green");
		set. add("red");
		//저장된 객체수 확인
		System.out.println(set.size());
		//출력
		for(String s:set)
			System.out.println(s);
	}

}
