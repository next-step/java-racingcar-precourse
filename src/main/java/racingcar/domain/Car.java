package racingcar.domain;

import static racingcar.type.ErrorMessageType.NOT_ALLOW_GREATER_THAN_FIVE;

import racingcar.exception.InputWrongValueException;

public class Car {
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
        validateCarNameLength();
    }

    public void validateCarNameLength() {
        if (this.name.length() > MAX_LENGTH) {
            throw new InputWrongValueException(NOT_ALLOW_GREATER_THAN_FIVE.getMessage());
        }
    }

    public void movingForward() {
        this.movingCount++;
    }

    public void printMovingForward() {
        System.out.println(this.name + " : " + convertHyphen());
    }

    private String convertHyphen() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.movingCount; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", movingCount=" + movingCount +
                '}';
    }
}
