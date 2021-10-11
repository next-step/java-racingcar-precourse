package racinggame.common;

public enum Message {
	CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 가능합니다.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
