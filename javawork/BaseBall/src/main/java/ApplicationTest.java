package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import main.java.controller.MainCtrl;
import main.java.service.Service;
import main.java.view.View;

class ApplicationTest {

	View view = new View();
	Service service = new Service();
	
	@Test
	void testResult() {		
		int[] res = service.result(); //결과도출
		boolean retChk = view.resultMsg(res);//결과메세지
		
		assertArrayEquals(res, res);
	}
	
	@Test
	void testCrRandomNumber() {		
		
		int ranNumber = service.getRandomNumber();
		int numberLength = String.valueOf(ranNumber).length();
		assertEquals(3, numberLength);

	}



}
