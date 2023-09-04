package bit701.day0904;

import java.net.MulticastSocket;

public class Ex9_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="apple";
		String str2="AppLe";
		String str3="Have a Good Day";
		String str4="   Happy   ";
		
		System.out.println(str3.length());//총길이 15
		System.out.println(str2.toLowerCase());//모두 소문자로
		System.out.println(str2.toUpperCase());//모두 대문자로
		System.out.println(str3.substring(5));//5부터 끝까지
		System.out.println(str3.substring(7,11));//7부터 10까지
		System.out.println(str3.charAt(0));//0번에 해당되는 문자
		System.out.println(str3.charAt(7));//7번에 해당되는 문자
		System.out.println(str3.indexOf('a'));//첫번째a의 위치
		System.out.println(str3.lastIndexOf('a'));//마지막a의 위치
		System.out.println(str4.length());//공백포함 총길이
		System.out.println(str4.trim().length());//앞뒤공백제거후 총길이
		System.out.println(str3.startsWith("Have"));//have로 시작하는가
		System.out.println(str3.endsWith("day"));//day로 끝나는가
		System.out.println(str1.equals(str2));//완벽히 같을 경우
		System.out.println(str1.equalsIgnoreCase(str2));//대소문자상관없이 같을경우
		System.out.println(str1.compareTo(str2));//양수 앞이 큰 값,음수 뒤가 더 큰 값
		System.out.println(str1.compareTo("apple"));//완전같을 경우 0
		
	}

}
