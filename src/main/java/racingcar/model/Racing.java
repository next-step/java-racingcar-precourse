package racingcar.model;

import java.util.List;

public class Racing {

    private final Cars cars;
    private final Count count;

    public Racing(String carNames, String countStr) {
        cars = new Cars(carNames);
        count = new Count(Integer.parseInt(countStr));
    }

    public List<Car> race() {
        count.down();

        return cars.move();
    }

    public boolean isRunning() {
        return count.isRemain();
    }

    public List<Car> getWinners() {
        return cars.getHeadCars();
    }
}
