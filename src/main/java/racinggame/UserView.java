package racinggame;

import nextstep.utils.Console;

public class UserView {

	public static final String MSG_TRY_COUNT = "시도할 회수는 몇회인가요?";
	public static final String MSG_INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public String inputTryNumber() {
		System.out.println(MSG_TRY_COUNT);
		return Console.readLine();
	}

	public String inputCarNames() {
		System.out.println(MSG_INPUT_NAMES);
		return Console.readLine();
	}
}
