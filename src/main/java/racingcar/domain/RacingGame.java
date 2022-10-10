package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.playStrategy.PlayBehavior;
import racingcar.dto.CarNames;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(CarNames carNames) {
        this.cars = new Cars(carNames);
    }

    public void go(PlayBehavior playBehavior) {
        cars.go(playBehavior);
    }

    public List<Car> getCarList() {
        return cars.getCarList();
    }

}
