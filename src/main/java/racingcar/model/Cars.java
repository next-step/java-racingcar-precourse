package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.StringValidator;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public Cars(List<String> cars) {
        StringValidator.validCarListCheck(cars);
        StringValidator.duplicateCarListCheck(cars);

        for (String car : cars) {
            carList.add(new Car(car));
        }
    }

    public void moveResult(MovementCondition randomMovement) {
        for (Car car : carList) {
            car.move(randomMovement);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
