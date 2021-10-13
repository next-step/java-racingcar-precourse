package racinggame.exception;

public enum ErrorMessage {

	CAR_NAME_MAX_LENGTH("자동차 이름은 5글자 이하만 가능합니다.")
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
