package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Rule;

import java.util.List;

public interface GameService {
    List<Car> getCars();
    List<Car> inputCars(List<Car> carList);
    Rule getRuleCount();

    void gameEnd();
    boolean play();
    int moveForward();
    void showScore();
    String getScore(int score);
    List<Car> getWinners(int count);
    void showWinners(int count);
}
