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

    public static void validateMoves(String moves) {
        try {
            int moveCount = Integer.parseInt(moves);
            if (moveCount <= 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
