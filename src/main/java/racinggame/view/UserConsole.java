package racinggame.view;

import nextstep.utils.Console;

public class UserConsole {
	public static final String TRIAL_NUM_ERROR_MESSAGE = "[ERROR] 시도 횟수는 2147483647 이하로 입력가능합니다.";

	public static String[] readCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		return carNames.split(",");
	}

	public static int readTrialNumber() {
		int trialNumber;
		try {
			trialNumber = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(TRIAL_NUM_ERROR_MESSAGE);
		}
		return trialNumber;
	}
}
