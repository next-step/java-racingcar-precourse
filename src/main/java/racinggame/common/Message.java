package racinggame.common;

public enum Message {
	INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?"),
	CAR_NAME_LENGTH_ERROR("[ERROR] 자동차 이름은 5자 이하만 가능합니다."),
	MOVE_COUNT_ERROR("[ERROR] 이동 횟수는 1 이상만 가능합니다."),
	WIN_HEAD("최종 우승자는 "),
	WIN_TAIL(" 입니다.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
