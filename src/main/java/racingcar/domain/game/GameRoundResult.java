package racingcar.domain.game;

import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;

import java.util.Collections;
import java.util.Map;

public class GameRoundResult {

    private Map<CarName, CarPosition> playedOneRoundResultMap;

    private GameRoundResult(Map<CarName, CarPosition> playedOneRoundResultMap) {
        this.playedOneRoundResultMap = playedOneRoundResultMap;
    }

    public static GameRoundResult createGameRoundResult(Map<CarName, CarPosition> playedOneRoundResultMap) {
        return new GameRoundResult(playedOneRoundResultMap);
    }

    public Map<CarName, CarPosition> getGameRoundResultMap() {
        return Collections.unmodifiableMap(playedOneRoundResultMap);
    }
}
