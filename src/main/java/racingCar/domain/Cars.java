package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = makeCars(carNames);
    }

    private List<Car> makeCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i], 0));
        }
        return carList;
    }
}
