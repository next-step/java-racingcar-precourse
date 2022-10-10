package racingcar.game.status;

import racingcar.game.GameContext;
import racingcar.view.port.outbound.StandardOutput;
import racingcar.view.status.EnterRetryCount;

public class MakeRetryCount implements Status {
    public static final int START_STEP = 0;

    @Override
    public Status next(GameContext gameContext) {
        try {
            int retryCount = Integer.parseInt(gameContext.getRetryReadLine());
            gameContext.setRetryCount(retryCount);
            return new GameStep();
        } catch (NumberFormatException e) {
            StandardOutput.Error("시도 횟수는 숫자여야 한다.");
            return new EnterRetryCount();
        }
    }
}
