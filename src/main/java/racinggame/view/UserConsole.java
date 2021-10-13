package racinggame.view;

import nextstep.utils.Console;

public class UserConsole {
	public static final String TRIAL_NUM_ERROR_MESSAGE = "[ERROR] 시도 횟수는 2147483647 이하의 숫자로 입력가능합니다.";

	public static String[] readCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String strCarNames = Console.readLine();
		String[] carNames = strCarNames.split(",");
		for (int i = 0; i < carNames.length; i++) {
			carNames[i] = carNames[i].trim();
		}
		return carNames;
	}

	public static int readTrialNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		int trialNumber;
		try {
			trialNumber = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(TRIAL_NUM_ERROR_MESSAGE);
		}
		return trialNumber;
	}
}
