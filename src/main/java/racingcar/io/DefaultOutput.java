package racingcar.io;

import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;

public class DefaultOutput implements Output {

	@Override
	public void printGameMessage(GameMessage message) {
		System.out.println(message);
	}

	@Override
	public void printErrorMessage(ErrorMessage message) {
		System.out.println(message);
	}
}
