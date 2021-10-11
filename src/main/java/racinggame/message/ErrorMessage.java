package racinggame.message;

public enum ErrorMessage {
	INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하여야 합니다."),
	INVALID_CAR_DISTANCE("자동차의 이동거리는 0 이상 9 이하여야 합니다."),
	DUPLICATE_CAR_NAMES("자동차 이름은 중복될 수 없습니다.");

	private final String value;

	ErrorMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
