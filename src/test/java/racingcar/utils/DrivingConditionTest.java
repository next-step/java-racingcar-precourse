package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DrivingConditionTest {

    @DisplayName("입력이 4이상일 경우 전진한다.")
    @MethodSource
    @ParameterizedTest
    public void isPossible(int input, Boolean possible) {
        // when
        boolean result = DrivingCondition.isPossible(input);
        // then
        assertThat(result).isEqualTo(possible);
    }

    private static Stream<Arguments> isPossible() {
        return Stream.of(
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(9, true)
        );
    }

}