package racingcar.message;

public enum ErrorMessage {
	INPUT_CAR_NAMES_ERROR("각 자동차 이름은 빈 값이 아닌 5자 이하로 입력해주세요."),
	INPUT_TRY_NO_ERROR("시도 횟수는 1 이상의 숫자를 입력해주세요.");

	private static final String MESSAGE_PREFIX = "[ERROR] ";
	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return MESSAGE_PREFIX + message;
	}
}
