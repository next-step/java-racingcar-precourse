package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("RacingCar 생성 테스트")
    @Nested
    class CreateTest {

        @DisplayName("RacingCarName과 RacingCarPosition으로 RacingCar를 생성할 수 있다.")
        @Test
        void createSuccessTest() {
            assertThatNoException()
                    .isThrownBy(() -> new RacingCar(new RacingCarName("aaa"), RacingCarPosition.startingLine()));
        }

        @ParameterizedTest(name = "RacingCarName 또는 RacingCarPosition이 null인 경우, IllegalArgumentException 예외가 발생한다.")
        @MethodSource("racingcar.domain.RacingCarTest#provideCreateFailTestArguments")
        void createFailTest(final RacingCarName name, final RacingCarPosition position) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new RacingCar(name, position));
        }
    }

    @DisplayName("RacingCar 전진 테스트")
    @Nested
    class MoveTest {

        @ParameterizedTest(name = "이동 조건이 충족하는 경우, 자동차는 전진한다.")
        @MethodSource("racingcar.domain.RacingCarTest#provideMoveTestArguments")
        void moveTest(final MoveCondition moveCondition,
                      final RacingCarPosition actualPosition,
                      final RacingCarPosition expectedPosition
        ) {
            final RacingCar racingCar = new RacingCar(new RacingCarName("aaa"), actualPosition);

            racingCar.move(moveCondition);

            assertThat(actualPosition)
                    .isEqualTo(expectedPosition);
        }
    }

    private static Stream<Arguments> provideCreateFailTestArguments() {
        return Stream.of(
                Arguments.of(null, RacingCarPosition.startingLine()),
                Arguments.of(new RacingCarName("aaa"), null),
                Arguments.of(null, null)
        );
    }

    private static Stream<Arguments> provideMoveTestArguments() {
        return Stream.of(
                Arguments.of((MoveCondition) () -> true, new RacingCarPosition(0), new RacingCarPosition(1)),
                Arguments.of((MoveCondition) () -> false, new RacingCarPosition(0), new RacingCarPosition(0))
        );
    }
}