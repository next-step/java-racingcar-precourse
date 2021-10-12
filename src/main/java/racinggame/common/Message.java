package racinggame.common;

public enum Message {
	CAR_NAME_LENGTH_ERROR("[ERROR] 자동차 이름은 5자 이하만 가능합니다."),
	MOVE_COUNT_ERROR("[ERROR] 이동 횟수는 1 이상만 가능합니다.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
