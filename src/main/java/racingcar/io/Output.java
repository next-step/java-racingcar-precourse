package racingcar.io;

import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;

public interface Output {
	void printGameMessage(GameMessage message);
	void printGameMessage(GameMessage message, Object... args);
	void printErrorMessage(ErrorMessage message);
	void printNewLine();
}
