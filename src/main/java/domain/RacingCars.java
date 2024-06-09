package domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        isDifferentCarName(cars);
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
}
