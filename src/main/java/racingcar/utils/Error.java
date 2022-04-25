package racingcar.utils;

public enum Error {
	INVALID_TEXT_NAME("유효하지 문자(공백)가 포함되어 있습니다."),
	INVALID_NAME_LENGTH("이름은 최소 1글자에서 최대 5글자까지 가능합니다."),
	INVALID_NUMBER("시도 횟수는 숫자여야 한다.")
	;

	public static final String COMMON_MESSAGE = "[ERROR]";

	private String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return COMMON_MESSAGE + " " +message;
	}
}
