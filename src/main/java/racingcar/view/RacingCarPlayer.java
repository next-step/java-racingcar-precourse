package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.RacingCarMessage;

public class RacingCarPlayer {

	public static String readInputCarNames() {
		System.out.println(RacingCarMessage.MESSAGE_INPUT_CAR);
		return Console.readLine();
	}

	public static String readInputAttemptNum() {
		System.out.println(RacingCarMessage.MESSAGE_INPUT_ATTEMPT);
		return Console.readLine();
	}

}
