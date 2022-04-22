package racingcar.model;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int CAN_MOVE = 4;
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if(isMove(randomNumber)) {
            distance++;
        }
    }

    public void validateName(String name) {
        validateNameLength(name);
    }

    public void validateNameLength(String name) {
        if(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    boolean isMove(int randomNumber) {
        return randomNumber >= CAN_MOVE;
    }

    public int getDistance() {
        return distance;
    }
}
