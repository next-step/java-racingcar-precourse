package racingcar.domain;

public class MoveCount {
    private static final int MIN_NUMBER = 0;
    private static final String INVALID_MESSAGE = "0 보다 큰 숫자를 입력해 주세요.";

    private final int count;

    public MoveCount(String userCount) {
        try {
            this.count = Integer.parseInt(userCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
        if (this.count <= MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }

    public int getCount() {
        return this.count;
    }
}
