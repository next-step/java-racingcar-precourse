package racinggame.view;

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

	public boolean showCarNamesErrorMsgIfInvalid(boolean isInvalid) {
		if (isInvalid) {
			System.out.println("[ERROR]: 잘못된 자동차 이름입니다. 5자 이하의 자동차 이름을 입력해주세요.");
		}
		return isInvalid;
	}

	public boolean showTryNumberErrorMsgIfInvalid(boolean isInvalid) {
		if (isInvalid) {
			System.out.println("[ERROR]: 시도 횟수가 잘못 되었습니다. 0이상의 숫자를 입력해주세요.");
		}
		return isInvalid;
	}
}
