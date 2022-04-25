package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInfoTest {
    @Test
    @DisplayName("유효한_게임수_검증")
    void 유효한_게임수_검증() {
        Assertions.assertDoesNotThrow(() -> new GameInfo("1"));
        Assertions.assertDoesNotThrow(() -> new GameInfo(intToString(Integer.MAX_VALUE)));
    }

    @Test
    @DisplayName("유효하지_않는_게임수_검증")
    void 유효하지_않는_게임수_검증() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new GameInfo(intToString(Integer.MIN_VALUE)));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new GameInfo(intToString(0)));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new GameInfo(intToString(Integer.MAX_VALUE + 1)));
    }

    String intToString(int number) {
        return Integer.toString(number);
    }
}