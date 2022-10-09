package racingcar.domain;

public class Car {

    private final CarName carName;
    private final MovementCount movementCount;

    public Car(String name) {
        this.carName = new CarName(name);
        this.movementCount = new MovementCount();
    }

    public String getCarName() {
        return carName.getName();
    }

    public Integer getMovementCount() {
        return this.movementCount.getCount();
    }

    public void move() {
        Integer moveNumber = MoveNumber.getRandomNumber();
        this.movementCount.move(moveNumber);
    }
}
