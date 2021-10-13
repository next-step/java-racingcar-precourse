package racinggame.domain;

public class LapCount {
    private static final int MIN_LAP_COUNT = 1;
    private final int value;

    public LapCount(int value) {
        validate(value);
        this.value = value;
    }

    public LapCount(String value) {
        this(parseNumber(value));
    }

    public int getValue() {
        return value;
    }

    public static void validate(int lapCount) {
        if (lapCount < MIN_LAP_COUNT)
            throw new IllegalArgumentException("[ERROR] 실행 횟수는 1회 이상이어야 합니다");
    }

    private static int parseNumber(String lapCount) {
        try {
            return Integer.parseInt(lapCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요");
        }
    }
}
