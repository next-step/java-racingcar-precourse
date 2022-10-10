package racingcar.score;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    private Score score;

    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    @Test
    @DisplayName("스코어 점수 올림")
    public void 점수_더함() {
        score.upScore();
        score.upScore();
        assertEquals(score.getScore(), 2);
    }

    @Test
    @DisplayName("전진일 경우 스코어 점수 올림")
    public void 전진_점수_더함() {
        score.upScore();
        score.upScore();
        assertEquals(score.getScore(), 2);
    }
}
