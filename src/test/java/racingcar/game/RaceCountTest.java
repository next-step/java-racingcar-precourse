package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceCount;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaceCountTest {
    @Test
    @DisplayName("시도 횟수 형식 예외 테스트")
    void validateRaceCountFormatTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RaceCount("test")
        );
    }

    @Test
    @DisplayName("시도 횟수 빈값 예외 테스트")
    void validateEmptyRaceCountTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RaceCount("")
        );
    }

    @Test
    @DisplayName("시도 횟수 0 예외 테스트")
    void validateZeroRaceCountTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RaceCount("0")
        );
    }

}
