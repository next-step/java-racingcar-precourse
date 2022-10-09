package racingcar;

public class Car {
    private static final int BOUNDARY_VALUE_FOR_MOVE = 4;
    private Name name;
    private Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    public void move(int singleDigitRandomValue) {
        if (singleDigitRandomValue >= BOUNDARY_VALUE_FOR_MOVE) {
            position.move();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
