package util;

public class Validator {
    public static void validateArrayExistence(String[] carArray) {
        if (carArray.length == 0) {
            throw new IllegalArgumentException("[ERROR] 1개 이상의 자동차를 입력해야 합니다.");
        }
    }

    public static void validateNameLength(String[] carArray) {
        for (String name: carArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하이어야 합니다.");
            }
            if (name.length() < 1) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1자 이상이어야 합니다.");
            }
        }
    }

    public static int validateNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
