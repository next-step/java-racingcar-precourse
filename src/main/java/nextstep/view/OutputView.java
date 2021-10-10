package nextstep.view;

import nextstep.constants.CommonConstants;

public class OutputView {

	private static final String ERROR_PREFIX = "[ERROR] ";
	private static final String ASKING_RACING_CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASKING_TRY_COUNT_INPUT = "시도할 회수는 몇회인가요?";
	private static final String EXECUTION_RESULT = "실행 결과";

	public void printErrorMessage(RuntimeException e) {
		System.out.println(ERROR_PREFIX + e.getMessage());
	}

	public void printForAskingRacingCarInput() {
		System.out.println(ASKING_RACING_CAR_INPUT);
	}

	public void printForAskingTryCountInput() {
		System.out.println(ASKING_TRY_COUNT_INPUT);
	}

	public void printExecutionResult() {
		System.out.println(CommonConstants.NEWLINE + EXECUTION_RESULT);
	}
}
