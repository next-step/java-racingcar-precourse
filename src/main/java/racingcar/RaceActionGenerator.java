package racingcar;

public class RaceActionGenerator {
    private static final int ACTION_NUM_BEGIN = 0;
    private static final int ACTION_NUM_END = 9;
    private static final int ACTION_NUM_TRAVEL_THRESHOLD = 4;

    private final RandomNumberPickable randomNumberPickable;

    public RaceActionGenerator(final RandomNumberPickable randomNumberPickable) {
        this.randomNumberPickable = randomNumberPickable;
    }

    public RaceAction nextAction() {
        final int actionNum = randomNumberPickable.pickNumberInRange(ACTION_NUM_BEGIN, ACTION_NUM_END);
        return (actionNum >= ACTION_NUM_TRAVEL_THRESHOLD) ? RaceAction.TRAVEL : RaceAction.STOP;
    }
}
