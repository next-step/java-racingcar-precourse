package racingcar.domain;

import java.util.List;

public interface VehicleFactory <T> {
    List<T> creates();
}