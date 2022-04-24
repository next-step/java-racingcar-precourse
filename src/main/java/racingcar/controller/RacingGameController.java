package racingcar.controller;

import racingcar.util.RandomGenerator;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final int MINIMUM_TRY_COUNT = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Cars cars;

    public void play() {
        initCars();
        raceStart(inputView.getTryCount());
    }

    private void initCars() {
        try {
            cars = new Cars(inputView.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            cars = new Cars(inputView.getCarNames());
        }
    }

    private List<CarDto> findWinners() {
        List<CarDto> winners = new ArrayList<>();

        for (Car winner : cars.findWinners()) {
            winners.add(winner.toDto());
        }

        return winners;
    }

    private void raceStart(int tryCount) {
        outputView.printStartMessage();

        while (tryCount-- > MINIMUM_TRY_COUNT) {
            cars.raceOneRound(RandomGenerator.generate(cars.size()));
            outputView.printRoundResult(cars.toDto());
        }

        outputView.printWinners(findWinners());
    }

}
