package model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winners;
    private final int maxPosition;

    public Winners(int maxPosition, List<Car> cars) {
        this.maxPosition = maxPosition;
        this.winners = new ArrayList<>();
        cars.forEach(this::registerIfMaxPosition);
    }

    private void registerIfMaxPosition(Car car) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.getName());
        }
    }

    public List<String> getWinnerNames() {
        return winners;
    }
}
