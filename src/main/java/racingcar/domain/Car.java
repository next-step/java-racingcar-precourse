package racingcar.domain;

public class Car {
    public static final String CAR_POSITION_MESSAGE = "-";
    public static final String NAME_DELIMITER = " : ";

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMove()) {
            position += 1;
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public boolean isBiggerThan(Car car) {
        return this.position > car.position;
    }

    public boolean isStop() {
        return this.position == 0;
    }

    public String createCarPositionMessage() {
        StringBuilder message = new StringBuilder();
        message.append(name.toString()).append(NAME_DELIMITER);
        for (int index = 0; index < position; index++) {
            message.append(CAR_POSITION_MESSAGE);
        }
        return message.toString();
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
