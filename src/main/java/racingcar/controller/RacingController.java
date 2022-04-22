package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.model.Winner;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private static final String DELIMITER = ",";

    public void start() {
        String carNames = InputView.inputCarNames();
        List<Car> cars = generateCars(carNames);
        String moveCount = InputView.inputMoveCount();
        Racing racing = new Racing(moveCount, cars);
        Winner winner = new Winner(racing.race());
        winner.printWinners();
    }

    public List<Car> generateCars(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER)).map(Car::new).collect(Collectors.toList());
    }
}
