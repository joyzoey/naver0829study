package bit701.day0904;

import java.util.Random;
public class Ex4_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//랜덤 선언
		Random r=new Random();
		for(int i=0;i<5;i++) {
			int n=r.nextInt(10);//0-9 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));//줄나눔줄

		
		for(int i=0;i<5;i++) {
			int n=r.nextInt(100+1);//1-100 사이 난수 발생
			System.out.println(n);
		}
		System.out.println("=".repeat(30));//줄나눔줄
		
		
		for(int i=0;i<5;i++) {
			int n=r.nextInt(26)+65;// 대문자 난수 발생 65-90
			System.out.println((char)n);//형변환
		}
		System.out.println("=".repeat(30));//줄나눔줄
		
		
		for(int i=0;i<5;i++) {
			int n=r.nextInt(26)+97;//소문자 난수 발생 97-127
			System.out.println((char)n);
		}
		System.out.println("=".repeat(30));//줄나눔줄
		
	}

}
