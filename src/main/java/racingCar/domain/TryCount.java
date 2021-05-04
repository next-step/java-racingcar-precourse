package racingCar.domain;

public class TryCount {
    private static final Integer ZERO = 0;

    private final int tryCount;

    public TryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public TryCount decrease() {
        if (tryCount <= ZERO) {
            throw new AlreadyEndRaceException("경기가 끝났습니다");
        }
        return new TryCount(tryCount - 1);
    }

    public boolean isAvailableGame() {
        return tryCount > 0;
    }
}
