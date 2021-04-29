package domain;

import domain.strategy.MoveStrategy;

public class Car {
    private CarName carName;
    private MoveStrategy moveStrategy;
    private Position position = new Position();

    public Car(String carName, MoveStrategy moveStrategy) {
        this(new CarName(carName), moveStrategy);
    }

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if(moveStrategy.movable()) {
            position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }
}
