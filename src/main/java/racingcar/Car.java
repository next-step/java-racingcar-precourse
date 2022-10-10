package racingcar;

public class Car {
    private final Name name;
    private Position position;

    Car(String name) {
        this.name = new Name(name);
        setDefaultPosition();
    }

    private void setDefaultPosition() {
        position = new Position();
    }

    String getCarPath() {
        return position.getPath();
    }

    String getCarName() {
        return name.getName();
    }

    void move(int number) {
        if (CarUtils.isMovable(number)) {
            position.moveForward();
        }
    }

    int getCarPosition() {
        return position.getPosition();
    }

    void tryMove() {
        move(CarUtils.pickNumber());
    }
}