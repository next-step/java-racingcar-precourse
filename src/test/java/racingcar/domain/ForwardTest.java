package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ForwardTest {

    private Forward forward;

    @BeforeEach
    void setUp() {
        forward = new Forward();
    }

    @Nested
    @DisplayName("move()")
    class Describe_MoveMethod {

        private final int moveCount = 10;

        @Test
        @DisplayName("전진 횟수를 증가시킨다.")
        void It_MoveCount() {
            for (int i = 1; i <= moveCount; i++) {
                assertThat(forward.move()).isEqualTo(i);
            }
            assertThat(forward.getCount()).isEqualTo(moveCount);
        }
    }

    @Nested
    @DisplayName("moveToDash()")
    class Context_MoveToDashMethod {

        private final int moveCount = 5;
        private final String dash = "-----";

        @Test
        @DisplayName("'-'를 전진 횟수 만큼 문자열로 반환한다.")
        void It_ReturnDash() {
            for (int i = 1; i <= moveCount; i++) {
                forward.move();
            }
            assertThat(forward.moveToDash()).isEqualTo(dash);
        }
    }
}
