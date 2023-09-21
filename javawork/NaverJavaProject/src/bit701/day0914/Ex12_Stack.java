package bit701.day0914;

import java.util.Stack;

public class Ex12_Stack {

	public static void main(String[] args) {
		String []groupA= {"우즈베키스탄","프랑스","미국","영국","태국","스위스","대한민국"};
		
		//Last-In-First-Out : LIFO 구조
		Stack<String> stack=new Stack<String>();
		
		//stack에 객체 추가하기
		for(String g:groupA)
		{
			stack.push(g);
		}
		//stack에 객체 빼기
		System.out.println("pop 으로 데이타 꺼내 출력하기");
		while(!stack.isEmpty())//비어있지 않다면 반복
		{
			System.out.println(stack.pop());
		}
	}

}