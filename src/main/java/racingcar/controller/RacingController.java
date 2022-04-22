package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.model.Winner;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    public void start() {
        List<Car> cars = generateCars(InputView.inputCarNames());
        String moveCount = InputView.inputMoveCount();
        Racing racing = new Racing(moveCount, cars);
        Winner winner = new Winner(racing.race());
        winner.printWinners();
    }

    public List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }
}
