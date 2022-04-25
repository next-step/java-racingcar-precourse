package racingcar.model;

import racingcar.domain.Cars;
import racingcar.domain.GameStatus;

import java.util.List;

public interface RacingCarModel {

    void init(String playerName) throws IllegalArgumentException;

    void run(String tryCount) throws IllegalArgumentException;

    List<GameStatus> getStatus();
    Cars getPlayer();

    String getWinner();

    boolean isValidGame();

    boolean isValidTry();
}
