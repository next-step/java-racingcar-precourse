package racingcar.io;

import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;

public interface Output {
	void printGameMessage(GameMessage message);
	void printErrorMessage(ErrorMessage message);
}
