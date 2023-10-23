package main.java.utils;

/**
 * 입력 벨리데이션 체크
 */
public class ValidationUtils {
	
	/**
	 * 입력자가 숫자를 입력했는지 졍규식 표현을 사용하여 체크 한다.
	 * 숫자만 입력하면 true
	 * 다른게 포함되어 있으면 false
	 * @param enterNumber
	 * @return boolean
	 */
	public static boolean NumberChk(String enterNumber) {
		return enterNumber.matches("[+-]?\\d*(\\.\\d+)?");
	}

}
