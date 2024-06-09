package domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        isDifferentCarName(cars);
        minimumNumofCars(cars.size());
        this.cars = cars;
    }

    private void isDifferentCarName(List<RacingCar> cars) {
        List<RacingCarName> carName = cars.stream()
                .map(idx -> idx.getRacingCarName())
                .collect(Collectors.toList());

        HashSet<RacingCarName> carNameDuplicateSet = new HashSet<>(carName);

        if (carNameDuplicateSet.size() != carName.size()) {
            throw new IllegalArgumentException("자동차 이름을 중복으로 사용할 수 없습니다.");
        }
    }

    private void minimumNumofCars(int size) {
        if (size < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 최소 2대 이상의 자동차를 만들어야 합니다.");
        }
    }
}
