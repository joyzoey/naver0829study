package main.java.controller;

import main.java.service.Service;
import main.java.view.View;

public class MainCtrl {
	
	View view = new View();				// 입출력 메소드
	Service service = new Service();	// 비즈니스 로직 메소드
	
	boolean firstChk = true;
	
	//게임 시작
	public void run() {
		
		if(firstChk) {
			view.startGameMsg(); //시작메세지
			service.crRandomNumber(); //랜덤생성
			firstChk = false;
		}
		
		view.enterNumber(); //숫자 입력
		int[] res = service.result(); //결과도출
		boolean retChk = view.resultMsg(res);//결과메세지
		
		//끝났을때 재시작 이벤트
		if(retChk) {
			String answer = view.gameReStart();
			if("1".equals(answer)) { //1번 찍으면
				firstChk = true; //다시 시작
				run();
			}
		} else {
			run();
		}
	}
	
 }
