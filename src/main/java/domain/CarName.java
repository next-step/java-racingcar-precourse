package domain;

import util.exception.ProException;
import util.exception.ProMessage;

public class CarName {
    public static final int MIN = 1;
    public static final int MAX = 5;
    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw ProException.from(ProMessage.INVALID_LENGTH_ERROR);
        }
        Validator.validateRange(carName.length(), MIN, MAX);
    }

    public String getValue() {
        return carName;
    }

    public static class Validator {
        private static void validateRange(int length, int start, int end) {
            if (isInvalidRange(length, start, end)) {
                throw ProException.from(ProMessage.INVALID_LENGTH_ERROR);
            }
        }

        private static boolean isInvalidRange(int number, int start, int end) {
            return number < start || number > end;
        }
    }
}