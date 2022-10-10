package racingcar.game.status;

import racingcar.domain.CarList;
import racingcar.game.GameContext;
import racingcar.view.port.outbound.StandardOutput;
import racingcar.view.status.EnterCarNameList;
import racingcar.view.status.EnterRetryCount;

public class MakeCarList implements Status {
    @Override
    public Status next(GameContext gameContext) {
        try {
            gameContext.setCarList(new CarList(gameContext.getCarNameList()));
            return new EnterRetryCount();
        } catch (IllegalArgumentException e) {
            StandardOutput.Error(e.getMessage());
            return new EnterCarNameList();
        }
    }
}
