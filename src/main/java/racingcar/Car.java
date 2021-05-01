package racingcar;

import utils.ValidationUtils;

public class Car {
    private static final int ARGUMENT_LENGTH = 5;
    private static final int MOVABLE_VALUE = 4;
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (isValidNameLength(name)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        this.name = name;
    }

    private boolean isValidNameLength(String name) {
        return name.trim().length() > ARGUMENT_LENGTH || ValidationUtils.isBlank(name);
    }

    public boolean isMovable(int num) {
        boolean movable = num >= MOVABLE_VALUE;
        if (movable) {
            this.position++;
        }

        return movable;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}