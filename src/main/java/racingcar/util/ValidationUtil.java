package racingcar.util;

public class ValidationUtil {
    private static final String MESSAGE_ERROR_INPUT_NULL = "입력된 값이 없습니다.";
    private static final String MESSAGE_ERROR_INVALID_STRING = "'%s'는 허용되지 않은 문자입니다. input: %s";
    private static final String MESSAGE_ERROR_INVALID_LENGTH = "앞뒤 공백을 제외하고 %d~%d 사이의 길이의 값을 입력해주세요. input: %s";
    private static final String MESSAGE_ERRRO_INVALID_NUMBER = "0보다 크고 %d보다 작은 수를 입력해주세요. input: %s";
    private static final String MESSAGE_ERROR_INVALID_POSITIVE_NUMBER = "양수를 입력해주세요. input: %s";

    private ValidationUtil() {
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(MESSAGE_ERROR_INPUT_NULL));
        }
    }

    public static void validateRestrictString(String input, String restrictString) {
        if (input.contains(restrictString)) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format(MESSAGE_ERROR_INVALID_STRING, restrictString, input)));
        }
    }

    public static void validateLength(String input, int minLength, int maxLength) {
        String trimmedName = input.trim();
        if (minLength > trimmedName.length() || trimmedName.length() > maxLength) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format(MESSAGE_ERROR_INVALID_LENGTH, minLength, maxLength, input)));
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format(MESSAGE_ERRRO_INVALID_NUMBER, Integer.MAX_VALUE, input)));
        }
    }

    public static void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format(MESSAGE_ERROR_INVALID_POSITIVE_NUMBER, input)));
        }
    }
}
