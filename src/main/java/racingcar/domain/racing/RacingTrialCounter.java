package racingcar.domain.racing;

public class RacingTrialCounter {
    private static final int MINIMUM_LIMIT_TRIALS = 1;
    private static final int INITIAL_COUNT = 0;

    private final int trialLimit;
    private int trialCount;

    public RacingTrialCounter(int trialLimit) {
        requireMovingTrialsPositive(trialLimit);
        this.trialLimit = trialLimit;
        this.trialCount = INITIAL_COUNT;
    }

    private void requireMovingTrialsPositive(int maxTrials) {
        if (maxTrials < MINIMUM_LIMIT_TRIALS) {
            throw new IllegalArgumentException("시도할 횟수는 " + MINIMUM_LIMIT_TRIALS + " 이상이어야 합니다! 입력값: " + maxTrials);
        }
    }

    public void incrementTrialCount() {
        if (isReachingTrialLimit()) {
            throw new IllegalStateException("경주 시도 횟수를 초과하였습니다!");
        }
        this.trialCount++;
    }

    public boolean isReachingTrialLimit() {
        return this.trialCount >= trialLimit;
    }
}
