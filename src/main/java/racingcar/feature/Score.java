package racingcar.feature;

public class Score {
    private static final String INITIALIZE_SCORE = "";
    private static final String ADVANCE = "-";

    private static final int SCORE_RANGE_MIN = 0;
    private static final int SCORE_RANGE_MAX = 9;
    private static final int ADVANCE_SCORE = 4;

    private String score;

    public Score() {
        this.score = INITIALIZE_SCORE;
    }

    public String getScore() {
        return this.score;
    }

    public void stopOrAdvance() {
        int generatedNumber = RandomGenerator.generate(SCORE_RANGE_MIN, SCORE_RANGE_MAX);
        if (isAdvance(generatedNumber)) {
            this.score += ADVANCE;
        }
    }

    public int getScoreCount() {
        return score.toCharArray().length;
    }

    private boolean isAdvance(int generatedNumber) {
        return generatedNumber >= ADVANCE_SCORE;
    }
}
