package racinggame;

public class LapCountValidator {
    private static final int MIN_LAP_COUNT = 1;

    public static void validate(int lapCount) {
        if (lapCount < MIN_LAP_COUNT)
            throw new IllegalArgumentException("[ERROR] 실행 횟수는 1회 이상이어야 합니다");
    }

    public static void validate(String lapCount) {
        int parseNumber = parseNumber(lapCount);
        validate(parseNumber);
    }

    private static int parseNumber(String lapCount) {
        try {
            return Integer.parseInt(lapCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요");
        }
    }
}
