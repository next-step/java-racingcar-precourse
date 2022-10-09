package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Positions {

    private final List<Position> value;

    public Positions(List<Position> positionList) {
        this.value = positionList;
    }

    public Position getMaximumPosition() {
        return Collections.max(value);
    }
}
