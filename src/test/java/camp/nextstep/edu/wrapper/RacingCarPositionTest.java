package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarPositionTest {

    private RacingCarPosition racingCarPosition;

    @BeforeEach
    void init() {
        racingCarPosition = new RacingCarPosition();
    }

    @Test
    @DisplayName("레이싱카 위치 생성 - 성공 테스트")
    void racingCarPosition_successTest() {
        // given & when & then
        assertThat(racingCarPosition.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5"})
    @DisplayName("레이싱카 위치 수정 - 성공 테스트")
    void setPosition_successTest(int position) {
        // given & when
        racingCarPosition.setPosition(position);

        // then
        assertThat(racingCarPosition.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5"})
    @DisplayName("레이싱카 위치 수정 - 실패 테스트")
    void setPosition_failureTest(int position) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCarPosition.setPosition(position))
                .withMessageContaining(Message.INVALID_POSITION);
    }
}
