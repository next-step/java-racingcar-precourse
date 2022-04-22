package racingcar.model;

import racingcar.view.ResultView;

public class Score {
    private int score;

    public Score() {
        this.score = 0;
    }

    public Score(int score) {
        this.score = score;
    }

    public void addScore() {
        this.score++;
    }

    public void maxScoreCompare() {
        if (MaxScore.getMaxScore() < this.score) {
            MaxScore.setMaxScore(this.score);
        }
    }

    public boolean isMaxScore() {
        return MaxScore.getMaxScore() == this.score;
    }

    public String getMark() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.score; i++) {
            sb.append(ResultView.MARK);
        }

        return sb.toString();
    }
}
