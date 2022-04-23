package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private final Distance distance;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.distance = new Distance();
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            this.distance.advance();
        }
    }

    public Distance getDistance() {
        return distance;
    }

    public int getDistanceCount() {
        return distance.getDistanceCount();
    }

    public String getDistanceByDash() {
        return distance.getDistanceByDash();
    }
}
