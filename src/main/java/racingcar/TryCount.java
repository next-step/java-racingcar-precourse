package racingcar;

public class TryCount {
    private final int value;

    private static final String NUMBER_REGEX = "[0-9]+";

    public TryCount(String input) {
        this.value = validateTryCount(input);
    }

    private int validateTryCount(String input) {
        if (input == null || !input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }

        return Integer.parseInt(input);
    }

    public int getValue() {
        return value;
    }
}
