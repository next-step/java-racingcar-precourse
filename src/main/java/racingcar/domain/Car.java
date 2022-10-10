package racingcar.domain;

public class Car {

    private static final int MIN_NUM_FOR_MOVE_FORWARD = 3;
    private final String name;
    private Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moveForward(int num) {
        if (num > MIN_NUM_FOR_MOVE_FORWARD) {
            position.setPosition(position.getPosition()+1);
        }
    }

    public String getCarPositionByStr() {
        return position.printPosition();
    }
}
