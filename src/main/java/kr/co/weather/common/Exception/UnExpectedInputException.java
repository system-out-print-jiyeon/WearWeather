package main.java.kr.co.weather.common.Exception;

public class UnExpectedInputException extends RuntimeException {
	
private static final long serialVersionUID = 3770035734870700178L;

	private String errorCode;
	private String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		this.setErrorMessage("실패하였습니다. 다시 시도해주세요.");
	}

	public UnExpectedInputException() {
		System.out.println("잘못된 값을 입력하셨습니다. 다시 시도해주세요.");
	}
	
	public UnExpectedInputException(ERROR error) {
		super(error.getMessage());
		this.errorCode = error.getCode();
		this.errorMessage = error.getMessage();
	}
	
	public static enum ERROR {
		INTERNAL_SERVER_ERROR("9999", "에러발생."),
		NOT_FOUND_LOCATION("9998", "마이페이지에서 올바른 지역을 다시 설정해주세요.");
		
		private String code;
		private String message;
		
		ERROR(String code, String message){
			this.code = code;
			this.message = message;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
}
