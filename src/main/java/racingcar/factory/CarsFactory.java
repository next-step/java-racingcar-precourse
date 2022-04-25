package racingcar.factory;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;
import racingcar.domain.engine.Engine;

public class CarsFactory {
    private static final int INIT_DISTANCE = 0;
    private static final int MOVABLE_DISTANCE = 1;
    private static final int MOVABLE_MIN_NUMBER = 4;

    public static Cars fromNames(List<String> carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.participate(new Car(carName, INIT_DISTANCE, new Engine(MOVABLE_MIN_NUMBER, MOVABLE_DISTANCE)));
        }
        return cars;
    }
}
