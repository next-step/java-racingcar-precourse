package racingcar.domain;

public class TryCount {
    public static final int MIN_COUNT = 1;
    public static final String ERROR_MESSAGE_TRY_COUNT_OUT_OF_RANGE = "시도 회수는 " + MIN_COUNT + " 이상만 입력 가능합니다.";
    private int count;

    private TryCount(int count) {
        validate(count);
        this.count = count;
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRY_COUNT_OUT_OF_RANGE);
        }
    }
}
