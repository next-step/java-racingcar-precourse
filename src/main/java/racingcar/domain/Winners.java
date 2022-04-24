package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> winnerCars) {
        this.cars = winnerCars;
    }

    public List<String> getNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car: cars) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
