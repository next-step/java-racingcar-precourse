package racingcar.domain;

import java.util.List;

public class RacingGameRecord {
    private final List<Cars> carsList;

    public RacingGameRecord(List<Cars> carsList) {
        this.carsList = carsList;
    }

    public List<Cars> getCarsList() {
        return carsList;
    }

    public void addCars(Cars cars) {
        carsList.add(cars);
    }
}
