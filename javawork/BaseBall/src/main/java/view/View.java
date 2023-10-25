package main.java.view;

import java.util.Scanner;

import main.java.utils.ValidationUtils;
import main.java.vo.BaseBall;

public class View {
	
	BaseBall baseBall = new BaseBall(); //게터세터
	ValidationUtils validationUtils = new ValidationUtils();
	
	
	//게임시작 문구 출력
		public void startGameMsg() {
			System.out.println("숫자 야구 게임을 시작합니다.");
		}
		
	
	//결과 출력
	public boolean resultMsg(int[] result) {
		boolean ret = false;
		int strike = result[0];
		int ball = result[1];		
		
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			ret = true;
		} else if (ball == 0 && strike == 0) {
			System.out.println("nothing");
		} else if (strike == 0) {
			System.out.println(ball + "볼");
		} else if (ball == 0) {
			System.out.println(strike + "스트라이크");
		}
		else {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}
		return ret;
	}
	




}
