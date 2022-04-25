package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarPositionTest {

    @DisplayName("RacingCarPosition 생성 테스트")
    @Nested
    class CreateTest {

        @ParameterizedTest(name = "0 이상의 값({arguments})으로 RacingCarPosition을 생성할 수 있다.")
        @ValueSource(ints = {0, 10})
        void createSuccessTest(final int position) {
            assertThatNoException()
                    .isThrownBy(() -> new RacingCarPosition(position));
        }

        @ParameterizedTest(name = "0 미만의 값({arguments})으로 RacingCarPosition을 생성할 수 없다.")
        @ValueSource(ints = -1)
        @NullSource
        void createFailTest(final Integer position) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new RacingCarPosition(position))
                    .withMessageContaining(String.valueOf(position));
        }

        @DisplayName("출발선의 위치는 0이다.")
        @Test
        void startingLineTest() {
            assertThat(RacingCarPosition.startingLine())
                    .isEqualTo(new RacingCarPosition(0));
        }
    }

    @DisplayName("RacingCarPosition 동등성 테스트")
    @Nested
    class EqualsTest {

        @DisplayName("RacingCarPosition은 동등성을 보장한다.")
        @Test
        void equalsTest() {
            final RacingCarPosition position1 = new RacingCarPosition(3);
            final RacingCarPosition position2 = new RacingCarPosition(3);

            assertThat(position1).isEqualTo(position2);
        }
    }

    @DisplayName("RacingCarPosition 전진 테스트")
    @Nested
    class MoveTest {

        @DisplayName("move 메소드는 position을 1 증가시킨다.")
        @Test
        void moveTest() {
            final int positionBeforeMove = 0;
            final RacingCarPosition position = new RacingCarPosition(positionBeforeMove);

            position.move();

            assertThat(position)
                    .isEqualTo(new RacingCarPosition(positionBeforeMove + 1));
        }
    }
}