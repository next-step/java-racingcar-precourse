package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private static final String CAR_DUP_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    private List<Car> racingCars;

    public RacingCars(List<Car> cars) {
        validateDuplicate(cars);
        this.racingCars = cars;
    }

    public List<RaceResult> race() {
        List<RaceResult> raceResults = new ArrayList<>();
        for (Car racingCar : racingCars) {
            racingCar.race();
            raceResults.add(new RaceResult(racingCar.getName(), racingCar.getDistance()));
        }
        return raceResults;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<String> noDuplicateCars = new HashSet<>();
        for (Car car : cars) {
            noDuplicateCars.add(car.getName());
        }
        if (noDuplicateCars.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_DUP_ERROR_MESSAGE);
        }
    }
}
