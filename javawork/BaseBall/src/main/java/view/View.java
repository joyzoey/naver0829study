package main.java.view;

import java.util.Scanner;

import main.java.utils.ValidationUtils;
import main.java.vo.BaseBall;

public class View {
	
	BaseBall baseBall = new BaseBall(); //게터세터
	ValidationUtils validationUtils = new ValidationUtils();
	
	
	//숫자 입력
	public void enterNumber() {
	    System.out.print("숫자를 입력해주세요 : ");
	    Scanner sc = new Scanner(System.in);

	    String enterNumber = sc.next();
	    boolean numberChk = ValidationUtils.NumberChk(enterNumber); // 숫자만 입력했는지 확인

	    if (!numberChk) {
	        throw new IllegalArgumentException("숫자가 아닙니다.");
	    } else if (enterNumber.length() != 3) {
	    	throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
	    }

	    baseBall.setEnterNumber(Integer.parseInt(enterNumber));
	}
	
	//재시작 입력
		public String gameReStart() {
			Scanner s = new Scanner(System.in);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			
			return s.next();
		}
	
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
