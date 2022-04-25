package racingcar.utils;

public class NumberValidator {
    private static final int MIN_RACE_COUNT = 1;
    private static final String INVALID_RACE_COUNT_MESSAGE = "[ERROR] 유효한 숫자를 입력해주세요.";

    public static boolean isValidCountInput(String count) {
        try {
            validCountCheck(count);
            positiveNumberCheck(Integer.parseInt(count));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void validCountCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
    }

    public static void positiveNumberCheck(int number) {
        if (number < MIN_RACE_COUNT) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
    }
}
