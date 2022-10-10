package racingcar.domain;

public class RacingCarScore {
    private Integer score;

    public RacingCarScore() {
        this.score = 0;
    }

    public Integer toInt() {
        return score;
    }

    public void addScore() {
        this.score++;
    }
}
