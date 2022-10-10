package racingcar.model.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.CarName;
import racingcar.model.car.CarPosition;
import racingcar.model.car.Cars;
import racingcar.view.Output;


/**
 * 경기 결과 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Result {

    private final int round;
    private final Cars cars;

    private final Winners winners;

    public Result(int round, Cars cars) {
        this.round = round;
        this.cars = cars;
        this.winners = new Winners(checkWinners());
    }

    private List<CarName> checkWinners() {
        cars.orderCarsByPosition();
        return cars.getWinners();
    }

    public Winners getWinners() {
        return winners;
    }

    public void printResult() {

        Output.printRoundResult(cars);
    }
}
