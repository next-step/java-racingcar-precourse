package racingcar.domain;

public class Car {
    private final CarName carName;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public static Car createCar(String name) {
        return new Car(new CarName(name));
    }

    public void move(int randomNumber) {
        if (Common.overMoveCondition(randomNumber)) {
            movePosition();
        }
    }

    private void movePosition() {
        position++;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position;
    }
}
