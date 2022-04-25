package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.NumberValidator;

public class Race {
    private int count;
    private static final int ZERO = 0;

    public Race(int count) {
        NumberValidator.positiveNumberCheck(count);
        this.count = count;
    }

    public void raceStart() {
        count--;
    }

    public boolean isRaceFinish() {
        return count == ZERO;
    }

    public List<String> raceResult(Cars cars) {
        int maxDistance = maxDistance(cars);
        return getWinner(cars.getCarList(), maxDistance);
    }

    private List<String> getWinner(List<Car> cars, int maxDistance) {
        List<String> result = new ArrayList<>();
        for(Car car : cars) {
            result = isWinner(result, car, maxDistance);
        }
        return result;
    }

    private List<String> isWinner(List<String> result, Car car, int maxDistance) {
        if (car.isMaxDistance(maxDistance)) {
            result.add(car.name());
        }
        return result;
    }

    private int maxDistance(Cars cars) {
        int maxDistance = ZERO;
        for(Car car : cars.getCarList()) {
            maxDistance = Math.max(maxDistance, car.position().length());
        }

        return maxDistance;
    }
}
