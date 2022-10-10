package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> value;


    public Cars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Name name = new Name(carName);
            Car car = new Car(name);
            cars.add(car);
        }
        this.value = cars;
    }

    public Cars() {
        this.value = new ArrayList<>();
    }


    public List<Car> getValue() {
        return value;
    }

    public boolean isSoleWinner(Cars winners) {
        return winners.getValue().size() == 1;
    }
}
