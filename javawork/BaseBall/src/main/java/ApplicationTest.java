package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import main.java.service.Service;
import main.java.view.View;
import main.java.vo.BaseBall;

class ApplicationTest {
   
   View view = new View();
   Service service = new Service();
   BaseBall baseBall = new BaseBall();


    @Test //랜덤숫자길이
    void testRanNumLength() {
        service.crRandomNumber();
        int randomNumber = service.getRandomNumber();

        assertEquals(3, String.valueOf(randomNumber).length());
    }

    @Test //스트라이크,볼
    void testResult() {
        service.setRandomNumber(123);
        service.setEnterNumber(321);

        int[] result = service.result();

        assertEquals(1, result[0]); // Strike
        assertEquals(2, result[1]); // Ball
    }
   
    @Test //입력 숫자 테스트
    void testEnterNumWithVal() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        view.enterNumber();
        int enteredNumber = baseBall.getEnterNumber();

        assertEquals(123, enteredNumber);
    }

    @Test //문자 오류 테스트
    void testEnterNumberWithString() {
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> view.enterNumber());
    }
    
    @Test //숫자 오버 테스트
    void testEnterOverNumber() {
        String input = "1223"; // Invalid input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> view.enterNumber());
    }
    
    @Test //재시작 테스트
    void testGameReStart() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = view.gameReStart();

        assertEquals("1", result);
    }
    
    @Test //boolean 결과 메세지
    public void testResultMsg() {
        int[] result1 = {3, 0};
        int[] result2 = {0, 0};
        int[] result3 = {0, 2};
        int[] result4 = {1, 1};
        int[] result5 = {1, 0};

        assertTrue(view.resultMsg(result1)); // 정답이라 true
        assertFalse(view.resultMsg(result2)); // 그외는 false
        assertFalse(view.resultMsg(result3)); 
        assertFalse(view.resultMsg(result4));
        assertFalse(view.resultMsg(result5));
    }

   

}