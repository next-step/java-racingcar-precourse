package racingcar.domain.response;

import racingcar.domain.Car;
import racingcar.domain.RoundStatus;

/**
 * @author : choi-ys
 * @date : 2022/04/23 5:08 오후
 */
public class CarRaceResult {
    private Car car;
    private RoundStatus roundStatus;

    public CarRaceResult(Car car, RoundStatus roundStatus) {
        this.car = car;
        this.roundStatus = roundStatus;
    }

    public Car getCar() {
        return car;
    }

    public RoundStatus getRoundStatus() {
        return roundStatus;
    }
}
