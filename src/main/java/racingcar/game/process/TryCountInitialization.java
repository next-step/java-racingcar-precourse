package racingcar.game.process;

import static racingcar.constants.Message.INIT_TRY_COUNT_MESSAGE;
import static racingcar.constants.Message.INVALID_TRY_COUNT_MESSAGE;

import racingcar.game.dto.GameStatus;
import racingcar.io.Input;
import racingcar.io.Output;

public class TryCountInitialization implements GameProcess {

    @Override
    public GameStatus execute(final GameStatus gameStatus) {
        Output.println(INIT_TRY_COUNT_MESSAGE);

        String inputTryCount = Input.readLine();
        int tryCount = stringToInteger(inputTryCount);

        return new GameStatus(new TryToMoveProcess(), gameStatus.getCars(), tryCount);
    }

    private int stringToInteger(final String inputTryCount) {
        int tryCount;

        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }

        return tryCount;
    }
}
