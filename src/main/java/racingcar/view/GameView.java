package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public interface GameView {
    String inputCarNames();

    String inputTurn();

    void responseError(IllegalArgumentException iae);

    void showGameProgress(Cars cars);

    void notifyStartGame();

    void responseWinner(List<Car> cars);
}
