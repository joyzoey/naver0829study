package main.java.view;

import java.util.Scanner;

import main.java.utils.ValidationUtils;
import main.java.vo.BaseBall;

public class EnterView {

	BaseBall baseBall = new BaseBall(); //게터세터
	ValidationUtils validationUtils = new ValidationUtils();	

	//숫자 입력
	public void enterNumber() {
		System.out.print("숫자를 입력해주세요 : ");

		Scanner sc = new Scanner(System.in);
		String enterNumber = sc.next();

		int errorNum = ValidationUtils.errorNum(enterNumber); //에러 체크 함수

		//에러 메세지 출력
		if (errorNum == 1) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		} else if (errorNum == 2) {
			throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
		}

		baseBall.setEnterNumber(Integer.parseInt(enterNumber));
	}

	//재시작 입력
	public String gameReStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		return sc.next();
	}

}
