package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.ErrorStatus;

public class StandardTest {

    @Test
    void 기준_객체_범위_벗어남() {
        assertThatThrownBy(
                () -> new Standard(-1))
                .hasMessage(ErrorStatus.STANDARD_OUT_OF_RANGE.getMessage());
        assertThatThrownBy(
                () -> new Standard(10))
                .hasMessage(ErrorStatus.STANDARD_OUT_OF_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("getStandardValues")
    void 기준_객체_움직임_가능_여부(int value, boolean isMovable) {
        Standard standard = new Standard(value);
        assertThat(standard.isMovable()).isEqualTo(isMovable);
    }

    private static Stream<Arguments> getStandardValues() {
        return Stream.of(
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(7, true)
        );
    }

}
