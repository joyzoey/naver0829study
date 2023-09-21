package bit701.day0914;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex11_Map {

	public static void main(String[] args) {
		//맵 생성
		Map<String, String> map=new HashMap<String, String>();
		
		//객체추가
		map.put("name", "캔디");
		map.put("score", "90");
		map.put("blood", "AB");
		map.put("ipsaday","1989-12-12");
		map.put("hp", "010-2222-4444");
		
		//키 셋 컬렉션 생성
		Set<String> keys=map.keySet();
		
		//출력
		for(String key:keys)
		{
			String v=map.get(key);
			System.out.println(key+":"+v);
		}
	}

}