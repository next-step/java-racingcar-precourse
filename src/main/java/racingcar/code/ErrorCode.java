package racingcar.code;

public enum ErrorCode {
	INVALID_NAME_RANGE_ERROR("자동차의 이름은 5자 이하만 입력 가능합니다."),
	INVALID_INPUT_CAR_NAME_ERROR("자동차 이름은 빈값이 포함될 수 없습니다."),
	INVALID_INPUT_GAME_COUNT_ERROR("경주 시도 횟수는 1 이상의 정수만 입력 가능합니다.");

	private String message;

	ErrorCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
