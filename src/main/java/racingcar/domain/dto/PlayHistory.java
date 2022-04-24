package racingcar.domain.dto;

import racingcar.domain.model.CarName;
import racingcar.domain.model.Distance;

public class PlayHistory {
    private final CarName carName;
    private final Distance distance;

    public PlayHistory(String carName, int distance) {
        this.carName = new CarName(carName);
        this.distance = new Distance(distance);
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
