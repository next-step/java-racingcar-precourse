package racingcar.message;

public enum GameMessage {
	INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
	INPUT_TRY_NO("시도할 회수는 몇 회 인가요?"),
	RACING_RESULT("실행 결과"),
	RACING_CAR("%s : %s");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
