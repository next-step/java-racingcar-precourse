package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(Names names) {
        cars = new ArrayList<>();
        initializeCars(names);
    }

    private void initializeCars(Names names) {
        for (Name carName : names.getCarNames()) {
            cars.add(new Car(carName, new ForwardCount(), new ForwardString(names.getCarNames().size())));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
