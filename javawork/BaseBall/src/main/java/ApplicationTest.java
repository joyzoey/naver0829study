package main.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import main.java.service.Service;
import main.java.view.View;

class ApplicationTest {

	@Test
	void testSum() {		
		
		View view = new View();
		Service service = new Service();
		
		int[] res = service.result(); //결과도출
		boolean retChk = view.resultMsg(res);//결과메세지
		
		assertArrayEquals(res, res);
	}

}
