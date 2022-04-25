package racingcar;

import static racingcar.Constants.*;

public class DriveNumber {
    private final int value;

    public DriveNumber(String value) {
        validateNumeric(value);
        int driveNumber = Integer.parseInt(value);
        validateRange(driveNumber);
        this.value = driveNumber;
    }

    public int getValue() {
        return value;
    }

    private void validateNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DRIVE_NUMBER_NOT_INTEGER_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(DRIVE_NUMBER_NEGATIVE_EXCEPTION_MESSAGE);
        }
    }
}
