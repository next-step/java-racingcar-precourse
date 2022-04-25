package racingcar.model;

import racingcar.model.primitive.Distance;
import racingcar.model.primitive.Name;
import racingcar.strategy.MovementStrategy;

public class Car {
    private final Name name;
    private final Distance distance;

    public Car(String name, int initialDistance) {
            this.name = new Name(name);
            this.distance = new Distance(initialDistance);
    }

    public void move(MovementStrategy movementStrategy) {
        if (movementStrategy.isMovingCar()) {
            distance.add();
        }
    }

    public String showPrimitiveValueWithParam(String data) {
        if(data.equals("Name")) {
            return name.getName();
        }
        if(data.equals("Distance")) {
            return String.valueOf(distance.getValue());
        }
        return "";
    }
    public String showResult() {
        return name.getName() + ":" + distance.getValue();
    }

}
