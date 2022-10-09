package racingcar.io;

import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;

public class DefaultOutput implements Output {

	@Override
	public void printGameMessage(GameMessage message) {
		System.out.println(message);
	}

	@Override
	public void printGameMessage(GameMessage message, Object... args) {
		System.out.println(String.format(message.toString(), args));
	}

	@Override
	public void printErrorMessage(ErrorMessage message) {
		System.out.println(message);
	}

	@Override
	public void printNewLine() {
		System.out.println();
	}
}
