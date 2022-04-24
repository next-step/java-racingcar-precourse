package racingcar.model;

public class Score {
    private String value = "";
    private int score = 0;

    public void setMoveForward() {
        value += "-";
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public String getScoreLine() {
        return value;
    }
}
