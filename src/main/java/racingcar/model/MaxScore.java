package racingcar.model;

public class MaxScore {
    private static int score = 0;

    public static int getMaxScore(){
        return score;
    }

    public static void setMaxScore(int maxScore) {
        score = maxScore;
    }
}
