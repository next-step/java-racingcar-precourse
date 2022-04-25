package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.GameStatus;

import java.util.List;

public interface RacingCarView {
    void printInputCarName();

    void printInputRunCount();

    void printStatus(List<GameStatus> status, Cars player);

    void printWinner(String winner);

    void printError(String message);
}
