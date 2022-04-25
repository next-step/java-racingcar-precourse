package racingcar.domain.car;

import racingcar.movestategy.MoveStrategy;

public class Car {

    private final CarName carName;
    private final Position position;
    private final MoveStrategy moveStrategy;

    private Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.position = Position.of();
        this.moveStrategy = moveStrategy;
    }

    public static Car of(String carName, MoveStrategy moveStrategy) {
        return new Car(CarName.of(carName), moveStrategy);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void forward() {
        position.forward(moveStrategy.move());
    }

    public boolean matchPosition(int position) {
        return this.position.matchPosition(position);
    }

    public boolean equalsPosition(Car car) {
        return this.position.equals(car.position);
    }

    public Boolean comparePostion(Car car) {
        return this.position.comparePosition(car.position);
    }

}
