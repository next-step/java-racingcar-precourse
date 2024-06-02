package validator;

public class CarNamesValidator {

    public static void validate(String input) throws IllegalArgumentException {
        validateNoSpace(input);
        input = validateEndsWithName(input);
        validateLength(input);
        validateOnlyLetters(input);
    }

    private static String validateEndsWithName(String input) throws IllegalArgumentException {
        return input.replaceAll(",$", "");
    }

    private static void validateNoSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백 없이 입력해 주세요.");
        }
    }

    private static void validateLength(String input) {
        for (String name : input.split(",")) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름의 길이는 5를 초과할 수 없고, 0일 수 없습니다.");
            }
        }
    }

    private static void validateOnlyLetters(String input) {
        for (String name : input.split(",")) {
            if (!name.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException("[ERROR] 숫자 또는 특수문자는 사용할 수 없습니다.");
            }
        }
    }
}
