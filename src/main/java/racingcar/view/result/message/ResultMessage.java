package racingcar.view.result.message;

import racingcar.model.racing.car.RacingCarsInGame;
import racingcar.view.Message;

public abstract class ResultMessage implements Message {
    protected RacingCarsInGame racingCarsInGame;

    protected ResultMessage(RacingCarsInGame racingCarsInGame) {
        this.racingCarsInGame = racingCarsInGame;
    }

    public abstract String getValue();
}
