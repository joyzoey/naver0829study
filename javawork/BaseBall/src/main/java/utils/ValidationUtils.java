package main.java.utils;

public class ValidationUtils {
	
	//true는 숫자, 다른게 포함되어있을 때 에러종류에 따라 메세지송출
	public static int errorNum (String enterNumber) {
	    boolean numberChk = ValidationUtils.NumberChk(enterNumber); // 숫자만 입력했는지 확인

	    if (!numberChk) {
	    	return 1;
	    } else if (enterNumber.length() != 3) {
	    	return 2;
	    }
	    return 0;
	    
	}
	
	//정규표현식으로 입력내용 확인
	public static boolean NumberChk(String enterNumber) {
		return enterNumber.matches("[+-]?\\d*(\\.\\d+)?");
	}
	
}
