package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int IS_MOVE = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move() {
        if(isMove()) {
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

    boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= IS_MOVE;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
