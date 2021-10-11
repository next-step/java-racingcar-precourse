package racinggame.message;

public enum PlayMessage {
	CAR_NAME_SEPARATOR(","),
	REQUEST_CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
	REQUEST_MOVE_COUNT_INPUT("시도할 회수는 몇회인가요?"),
	PLAY_RESULT_START("실행 결과"),
	DISTANCE_VISUALIZATION_UNIT("-"),
	WINNER_PREFIX("최종 우승자는 "),
	WINNER_SUFFIX("입니다.");

	private final String value;

	PlayMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
