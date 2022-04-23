package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RaceJudgment {
    private final Cars cars;
    private final List<Car> winners;

    public RaceJudgment(Cars cars) {
        this.cars = cars;
        this.winners = new ArrayList<>();
        judgement(cars);
    }

    private void judgement(Cars cars) {
        int maxDistance = getMaxDistance(cars);
        for (Car car : cars.getCars()) {
            isEqualsDistanceAndAdd(car, maxDistance);
        }
    }

    private int getMaxDistance(Cars cars) {
        List<Car> carList = cars.getCars();
        int max = -1;

        for (int i = 0; i < carList.size(); i++) {
            int number = carList.get(i).getDistanceCount();
            max = compareMaxNumber(max, number);
        }

        return max;
    }

    private int compareMaxNumber(int source, int target) {
        if (source < target) {
            return target;
        }

        return source;
    }

    private void isEqualsDistanceAndAdd(Car car, int maxDistance) {
        if (car.getDistanceCount() == maxDistance) {
            this.winners.add(car);
        }
    }

    public Winners getWinners() {
        return new Winners(this.winners);
    }
}
