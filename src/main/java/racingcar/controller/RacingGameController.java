package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car.Car;
import racingcar.model.Car.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.function.Predicate;

public class RacingGameController {
    public static final int RANDOM_START = 0;
    public static final int RANDOM_END = 9;
    public static final int RANDOM_CHECKER = 3;
    private Predicate<Car> drivingStrategy;
    private Cars cars;
    private Round round;

    public RacingGameController() {
        drivingStrategy = getDefaultDrivingStrategy();
    }

    private Predicate<Car> getDefaultDrivingStrategy() {
        return (car) -> Randoms.pickNumberInRange(RANDOM_START, RANDOM_END) > RANDOM_CHECKER;
    }

    public void play() {
        cars = new Cars(InputView.carNamesInput());
        round = new Round(InputView.gameCountInput());
        race();
        OutputView.resultPrint(cars);
    }

    private void race() {
        for (int i = 0; i < round.getRound(); i++) {
            System.out.println();
            cars.drive(drivingStrategy);
            System.out.println(cars.print());
        }
    }

}
