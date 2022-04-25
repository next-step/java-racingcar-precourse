package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<String> winners;
    private final String delimiter = ", ";

    public Winners(List<Car> cars) {
        this.winners = createWinners(cars);
    }

    public String winners() {
        return String.join(delimiter, this.winners);
    }

    private List<String> createWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        TopMileage topMileage = new TopMileage(cars);
        for (Car car : cars) {
            winners(winners, car, topMileage);
        }
        return winners;
    }

    private void winners(List<String> winners, Car car, TopMileage topMileage) {
        if (car.mileage.mileage() == topMileage.topMileage()) {
            winners.add(car.carName.carName());
        }
    }
}
