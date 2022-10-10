package racingcar.game.dto;

import racingcar.game.process.GameProcess;
import racingcar.model.Cars;

public class GameStatus {

    private final GameProcess gameProcess;
    private final Cars cars;
    private final int tryCount;

    public GameStatus(GameProcess gameProcess, Cars cars, int tryCount) {
        this.gameProcess = gameProcess;
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public GameProcess getGameProcess() {
        return gameProcess;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
