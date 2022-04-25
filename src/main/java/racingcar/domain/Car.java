package racingcar.domain;

/**
 * 경주 할 자동자
 *
 * @author suji
 * @date 2022-04-23
 **/
public class Car {

    private final CarName carName;
    private final MovementCount movementCount;

    private Car(CarName carName, MovementCount movementCount) {
        this.carName = carName;
        this.movementCount = movementCount;
    }

    public static Car newInstance(String name) {
        return new Car(new CarName(name), new MovementCount());
    }

    public void move(int moveNumber) {
        this.movementCount.movingForward(moveNumber);
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public Integer getMovementCount() {
        return this.movementCount.getCount();
    }
}
