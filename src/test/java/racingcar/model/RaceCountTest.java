package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountTest {

    @Test
    @DisplayName("시도 횟수 입력")
    public void testInputProgressCount() {
        RaceCount raceCount = RaceCount.generate("5");
        Assertions.assertEquals(5, raceCount.get());
    }

    @Test
    @DisplayName("시도 횟수 공백 입력")
    public void testInputEmptyProgressCount() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            RaceCount.generate("");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 시도 횟수 입력")
    public void testInputNotIntegerProgressCount() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            RaceCount.generate("null");
        });
    }

    @Test
    @DisplayName("시도 횟수 0 입력")
    public void testInputZeroProgressCount() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            RaceCount.generate("0");
        });
    }
}
