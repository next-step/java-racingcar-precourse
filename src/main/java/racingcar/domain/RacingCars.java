package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars(final String carNames) {
        joinCar(carNames);
    }

    private void joinCar(final String carNames) {
        for (String carName : carNames.split(",")) {
            cars.add(createCar(carName));
        }
    }

    private Car createCar(final String carName) {
        Car car = new Car(carName);
        if (cars.contains(car)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 중복이 불가능합니다.");
        }
        return car;
    }

    public List<Car> winners() {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            distinguish(car, winners);
        }
        return winners;
    }

    private void distinguish(final Car car, final List<Car> winners) {
        RaceResult raceResult = compete(car);
        if (raceResult.isWinner()) {
            winners.add(car);
        }
    }

    private RaceResult compete(final Car car) {
        RaceResult raceResult = new RaceResult();
        for (Car competitor : cars) {
            RaceStatus raceStatus = car.compete(competitor);
            raceResult.report(raceStatus);
        }
        return raceResult;
    }

    public List<Car> getCars() {
        return cars;
    }
}
