package racinggame.utils;

public enum Message {
	INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
	OUTPUT_RESULT("실행 결과"),
	OUTPUT_WINNER("최종 우승자는 %s 입니다."),
	ERROR("[ERROR] 입력값 오류");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
