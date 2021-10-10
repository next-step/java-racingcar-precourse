package nextstep.view;

public class OutputView {

	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String ASKING_RACING_CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public void printErrorMessage(RuntimeException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printForAskingRacingCarInput() {
		System.out.println(ASKING_RACING_CAR_INPUT);
	}
}
