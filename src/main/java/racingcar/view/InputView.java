package racingcar.view;

import racingcar.utils.InputUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";


	public String inputCarNames() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		return InputUtils.inputString(readLine());
	}

	public int inputMaxRaceNumber() {
		System.out.println(TRY_COUNT_INPUT_MESSAGE);
		return InputUtils.inputInt(readLine());
	}
}
