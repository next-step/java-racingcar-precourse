package domain;

import domain.strategy.MoveStrategy;

public class Car {
    private CarName carName;
    private MoveStrategy moveStrategy;
    private Position position;

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
        this.position = new Position(carName);
    }

    public void move() {
        if(moveStrategy.movable()) {
            position = position.increase();
        }
    }

    public CarHistory getCurrentInfo() {
        return new CarHistory(carName, position);
    }

    public Position getPosition() {
        return position;
    }
}
