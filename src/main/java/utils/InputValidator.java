package utils;

public class InputValidator {
    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 적어도 하나의 자동차 이름을 입력해야 합니다.");
        }
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }
}
