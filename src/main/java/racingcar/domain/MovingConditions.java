package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class MovingConditions {

    private final Map<Car, MovingCondition> mapping = new HashMap<>();

    public void match(Car car, MovingCondition condition) {
        mapping.put(car, condition);
    }

    public MovingCondition conditionOf(Car car) {
        return mapping.get(car);
    }

    public int numberOfConditions() {
        return mapping.size();
    }
}
