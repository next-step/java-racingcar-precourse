package racingcar.view.status;

import racingcar.game.GameContext;
import racingcar.game.status.MakeRetryCount;
import racingcar.game.status.Status;
import racingcar.view.port.inbound.StandardInput;
import racingcar.view.port.outbound.StandardOutput;

public class EnterRetryCount implements Status {
    @Override
    public Status next(GameContext gameContext) {
        StandardOutput.println("시도할 회수");
        gameContext.setRetryReadLine(StandardInput.readLine());
        return new MakeRetryCount();
    }
}
