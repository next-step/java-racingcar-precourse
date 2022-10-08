package racingcar.domain;

public class TryCount {
    public static final int MINIMUM_POSITIVE_NUMBER = 1;
    private final int count;

    public TryCount(String countAsString) {
        validateCountIsNumber(countAsString);
        int count = Integer.parseInt(countAsString);
        validateIfCountIsPositive(count);
        this.count = count;
    }

    private void validateIfCountIsPositive(int count) {
        if (count < MINIMUM_POSITIVE_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 양수여야 합니다.");
        }
    }

    private void validateCountIsNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수는 숫자형식 이어야 합니다.");
        }
    }

    public int value() {
        return count;
    }
}
