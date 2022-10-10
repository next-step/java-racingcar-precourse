package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class racingcarsName {
    private final List<racingcarName> cars;
    public racingcarsName(List<racingcarName> cars) {
        this.cars = new ArrayList<>(cars);
    }
}