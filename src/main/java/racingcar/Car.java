package racingcar;

public class Car {
    private static final int ARGUMENT_LENGTH = 5;
    private static final int MOVABLE_VALUE = 4;
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private final String name;
    private int position;

    public Car(String name) {
        if (isValidNameLength(name)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
        this.name = name;
    }

    private boolean isValidNameLength(String name) {
        String checkName = name.trim();
        return checkName.length() > ARGUMENT_LENGTH || "".equals(checkName);
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