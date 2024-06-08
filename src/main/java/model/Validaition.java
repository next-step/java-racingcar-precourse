package model;

public class Validaition {

    public static void validateInputCarNames(String inputCarNames) {
        inputCarNames = inputCarNames.trim();
        if (inputCarNames.isEmpty()
                || inputCarNames.startsWith(",")
                || inputCarNames.endsWith(",")
        ) {
            throw new IllegalArgumentException("올바른 입력형태가 아닙니다.");
        }
    }

    public static void validateTrialCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
