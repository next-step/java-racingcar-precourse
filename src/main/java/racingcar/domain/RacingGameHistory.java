package racingcar.domain;

import java.util.List;

public class RacingGameHistory {
    private final List<Cars> carsList;

    public RacingGameHistory(List<Cars> cars) {
        carsList = cars;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void addCars(Cars cars) {
        carsList.add(cars);
    }
}
