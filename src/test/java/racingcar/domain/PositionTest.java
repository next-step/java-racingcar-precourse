package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest {

    @ParameterizedTest
    @MethodSource("getCompareValues")
    void 위치_객체_상호비교(int first, int second, int compareResult) {
        Position one = new Position(first);
        Position two = new Position(second);
        assertThat(Position.compare(one, two)).isEqualTo(compareResult);
    }

    private static Stream<Arguments> getCompareValues() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(2, 1, 1),
                Arguments.of(3, 3, 0)
        );
    }

}
