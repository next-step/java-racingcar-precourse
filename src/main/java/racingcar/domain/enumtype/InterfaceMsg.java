package racingcar.domain.enumtype;

public enum InterfaceMsg {
	REQUEST_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : "),
	REQUEST_INPUT_GAME_TRY_COUNT("시도할 회수는 몇회인가요? : ")
	;

	private String value;
	InterfaceMsg(String value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public String getValue() {
		return value;
	}
}
