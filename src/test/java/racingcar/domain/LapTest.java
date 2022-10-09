package racingcar.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("바퀴 수 관련 기능")
class LapTest {
    @DisplayName("바퀴 수를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2147483647"})
    void create(String text) {
        // when
        Lap lap = Lap.from(text);

        // then
        assertThat(lap.get()).hasToString(text);
    }

    @DisplayName("유효하지 않은 값으로 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"a", "0", "2147483648"})
    void invalid(String text) {
        // when
        ThrowingCallable throwingCallable = () -> Lap.from(text);

        // then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lap.INVALID_RANGE_MESSAGE);
    }
}
