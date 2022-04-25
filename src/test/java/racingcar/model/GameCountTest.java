package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameCountTest {

    @DisplayName("GameCount 생성 테스트")
    @Test
    void gameCountTest() {

        // given
        String count = "5";

        // when
        GameCount gameCount = new GameCount(count);

        // then
        assertNotNull(gameCount);
    }

    @DisplayName("play() 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false", "3:false"}, delimiter = ':')
    void playTest(String count, boolean gameEnd) {

        // given
        GameCount gameCount = new GameCount(count);

        // when
        gameCount.play();

        // then
        assertThat(gameCount.isEnd()).isEqualTo(gameEnd);
    }
}
