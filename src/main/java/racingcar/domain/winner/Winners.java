package racingcar.domain.winner;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public Cars findWinners(Cars cars) {
        return filterWinners(cars, getMaxPosition(cars));
    }

    private Cars filterWinners(Cars cars, int maxPosition) {
        for (Car car : cars.getCars()) {
            addWhenWinner(car, maxPosition);
        }
        return new Cars(winners);
    }

    private void addWhenWinner(Car car, int maxPosition) {
        if (car.isMaxPosition(maxPosition)) {
            winners.add(car);
        }
    }

    private int getMaxPosition(Cars cars) {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = car.updateMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
