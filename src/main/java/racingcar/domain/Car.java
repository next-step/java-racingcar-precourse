package racingcar.domain;

public class Car {
    private static final int NUMBER_FOR_MOVE = 4;
    private final CarName carName;
    private final CarPosition carPosition;

    public Car(String name) throws IllegalArgumentException {
        carName = new CarName(name);
        carPosition = new CarPosition();
    }

    public void moveForward() {
        carPosition.forwardPosition();
    }

    public void moveOrStop(NumberStrategy numberStrategy) {
        if (numberStrategy.generateNumber() >= NUMBER_FOR_MOVE) {
            moveForward();
        }
    }

    public String getCarName() {
        return carName.toString();
    }

    public int getPosition() {
        return carPosition.currentPosition();
    }

}
