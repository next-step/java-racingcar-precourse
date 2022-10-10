package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.code.GameRoundErrorCode;

public class GameRoundTest {

    @ParameterizedTest
    @ValueSource(strings = { "오", "구" })
    void 숫자가_아닌_문자(String round) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new GameRound(round); });

        assertEquals(GameRoundErrorCode.NUMBER.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 시도_횟수_NULL_확인(String round) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new GameRound(round); });

        assertEquals(GameRoundErrorCode.NULL.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "   " })
    void 시도_횟수_공백_확인(String round) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new GameRound(round); });

        assertEquals(GameRoundErrorCode.EMPTY.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "0" })
    void 시도_횟수_0회_확인(String round) {
        RuntimeException exception = assertThrows(IllegalArgumentException.class,
            () -> { new GameRound(round); });

        assertEquals(GameRoundErrorCode.ZERO.getMessage(), exception.getMessage());
    }
}
