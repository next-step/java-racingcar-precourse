package racingcar.model.user;

public class RacingRepeatCount {

    private final int repeatCount;

    public RacingRepeatCount(int repeatCount) {
        validate(repeatCount);
        this.repeatCount = repeatCount;
    }

    private void validate(int repeatCount) {
        if (repeatCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수이어야 합니다.");
        }
    }

    public int getRepeatCount() {
        return repeatCount;
    }

}
