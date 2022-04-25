package racingcar.Util;

public class Validation {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public static boolean validateCarName(String carName) {
        return carName.length() >= MIN_LENGTH && carName.length() <= MAX_LENGTH;
    }

    public static boolean validateMovement(String movement) {
        return movement.chars().allMatch(Character::isDigit);
    }
}
