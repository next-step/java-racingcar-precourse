package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static racingcar.RacingProperties.VALUE_MAX_NUMBER;
import static racingcar.RacingProperties.VALUE_MIN_NUMBER;

public class Cars {

    private final List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public void race() {
        for (Car car : getCars()) {
            int number = Randoms.pickNumberInRange(VALUE_MIN_NUMBER, VALUE_MAX_NUMBER);
            car.drive(number);
        }
    }


}
