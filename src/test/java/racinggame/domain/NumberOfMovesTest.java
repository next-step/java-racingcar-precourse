package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfMovesTest {

    @DisplayName("시도할 횟수를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5"})
    void create(final String n) {
        assertDoesNotThrow(
            () -> new NumberOfMoves(n)
        );
    }

    @DisplayName("시도할 횟수는 숫자여야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a"})
    void invalidNumberOfMoves(final String n) {
        assertThatThrownBy(
            () -> new NumberOfMoves(n)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수는 0보다 커야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void invalidNumberOfMoves2(final String n) {
        assertThatThrownBy(
            () -> new NumberOfMoves(n)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
