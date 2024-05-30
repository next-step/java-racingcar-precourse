package validator;

public class AttemptValidator {

    public static void validate(String input) throws IllegalArgumentException {
        validateInteger(input);
        validateMoreThanZero(input);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
        }
    }

    private static void validateMoreThanZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해 주세요.");
        }
    }
}
