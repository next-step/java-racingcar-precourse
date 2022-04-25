package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class GameHistoryTest {

    @DisplayName("GameHistory 생성 테스트")
    @Test
    void createTest() {

        // given
        GameHistory gameHistory = new GameHistory();

        // when & then
        assertNotNull(gameHistory);
    }

    @DisplayName("record 테스트")
    @Test
    void recordTest() {

        // given
        GameHistory gameHistory = new GameHistory();

        // when
        gameHistory.record("history");

        // then
        assertThat(gameHistory.toString()).contains("history");
    }
}
