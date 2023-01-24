package main.java.kr.co.weather.common.Exception;

public class UnExpectedInputException extends RuntimeException {
	
private static final long serialVersionUID = 3770035734870700178L;

	public UnExpectedInputException() {
		System.out.println("잘못된 값을 입력하셨습니다. 다시 시도해주세요.");
	}
	
}
