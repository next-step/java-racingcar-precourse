package racingcar.game;

public class RacingStageCount {

    private static final String ILLEGAL_STAGE_COUNT_MESSAGE = "시도횟수는 1 이상의 숫자여야 합니다.";
    private final int stageCount;

    public RacingStageCount(String stageCount) {
        try {
            this.stageCount = Integer.parseInt(stageCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_STAGE_COUNT_MESSAGE);
        }
        if (this.stageCount == 0) {
            throw new IllegalArgumentException(ILLEGAL_STAGE_COUNT_MESSAGE);
        }
    }

    public int getStageCount() {
        return stageCount;
    }
}
