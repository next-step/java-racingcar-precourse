package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int GO_MIN = 0;
    public static final int GO_MAX = 9;
    public static final int MOVABLE_MIN = 4;
    public static final int NAME_MAX = 5;
    public static final int NAME_MIN = 1;
    public static final String INVALID_SIZE = "이름은 5자 이하만 가능 (공백 금지)";

    private String name;
    private int mileage;
    private boolean moved;

    public Car(String name) {
        this.name = name;
        validateNameSize();
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isMoved() {
        return moved;
    }

    public String getName() {
        return name;
    }

    private void validateNameSize() {
        int nameSize = this.name.length();
        if (nameSize < NAME_MIN || nameSize > NAME_MAX) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public void move() {
        if (isMovable(makeRandom())) {
            mileage++;
            moved = true;
            return;
        }

        moved = false;
    }

    public boolean isMovable(int input) {
        return input >= MOVABLE_MIN;
    }

    private int makeRandom() {
        return Randoms.pickNumberInRange(GO_MIN, GO_MAX);
    }

    public void moveTest(int input) {
        if (isMovable(input)) {
            mileage++;
            moved = true;
            return;
        }

        moved = false;
    }

}
