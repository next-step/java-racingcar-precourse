package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRuleTest {

    private static final String INPUT_TRY_COUNT = "3";
    private TryCount tryCount;
    private GameRule gameRule;

    @BeforeEach
    void setUP() {
        tryCount = new TryCount(INPUT_TRY_COUNT);
        gameRule = new GameRule(tryCount);
    }

    @Test
    void 입력_숫자_동일() {
        assertEquals(gameRule.getTryCount(), Integer.parseInt(INPUT_TRY_COUNT));
    }

    @Test
    void 자동차_이동_정지_결과() {
        assertThat("true, false").contains(String.valueOf(gameRule.canGoForward()));
    }


}
