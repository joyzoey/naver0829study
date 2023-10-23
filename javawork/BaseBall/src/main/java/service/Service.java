package main.java.service;

import java.util.stream.Stream;

import main.java.vo.BaseBall;


public class Service extends BaseBall{
	
	BaseBall baseBall = new BaseBall();
	
	//랜덤 숫자 생성 메소드
	public void crRandomNumber() {
		String stringNum = "";
		boolean[] used = new boolean[10];
		
		for(int i=0; i<3; i++) {
			int setNum;
			do {
				setNum = (int)(Math.random()*9)+1;
			} while (used[setNum]);
			
			stringNum += "" + setNum ;
			used[setNum] = true;
		}
		baseBall.setRandomNumber(Integer.parseInt(stringNum));
	}
	
	//결과 생성 과정 메소드
	public int[] result() {
		int enterNumber = baseBall.getEnterNumber(); //입력숫자받기
		int randomNumber = baseBall.getRandomNumber();//랜덤숫자 받기
		
		//System.out.println("enterNumber : " +  Arrays.toString(crArrayNumber(enterNumber)));
		//System.out.println("randomNumber : " +  Arrays.toString(crArrayNumber(randomNumber)));
				
		//숫자 리스트로 바꾸기
		int[] enterList = crArrayNumber(enterNumber); 
		int[] randomList = crArrayNumber(randomNumber);
		
		int ball = calBall(enterList, randomList); //볼갯수 반환 메소드
		int strike = calStrike(enterList, randomList); //스트라이크 개수 반환 메소드
		int[] result = new int[] {strike, ball};
		return result;
	}
	
	//리스트로 바꾸는 메소드
	public int[] crArrayNumber(int number) {
		int[] list = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
		return list;
	}
	
	//스트라이크 반환 메소드
	private static int calStrike(int[] enterList, int[] randomList) {
		// TODO Auto-generated method stub
		int strike = 0;
		for(int i=0; i<randomList.length; i++) {
			if(randomList[i] == enterList[i]) {
				strike++;
			}
		}
		return strike;
	}

	//볼갯수 반환 메소드
	private static int calBall(int[] enterList, int[] randomList) {
		// TODO Auto-generated method stub
		int ball = 0;
		for (int i=0; i<randomList.length; i++) {
			if(randomList[i] != enterList[i] && contains (randomList, enterList[i])) {
				ball++;
			}
		}
		return ball;
	}
	
	//포함 확인 메소드
	private static boolean contains(int[] randomList, int i) {
		// TODO Auto-generated method stub
		for (int n : randomList) {
			if(n == i) {
				return true;
			}
		}
		return false;
	}
	
	
	

}
