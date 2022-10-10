package racingcar.score;

import lombok.Getter;
import lombok.Setter;

public class Score {
    @Getter
    @Setter
    private int score = 0;

    public void upScore() {
        this.score++;
    }
}
