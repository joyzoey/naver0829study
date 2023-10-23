package main.java;

import main.java.controller.MainCtrl;

public class Application {
	
	public static void main(String[] args) {
		
		MainCtrl mainCtrl = new MainCtrl();
		
		// Game 시작
		mainCtrl.run();
	}
}
