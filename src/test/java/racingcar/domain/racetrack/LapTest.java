package racingcar.domain.racetrack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racetrack.Lap;
import racingcar.message.ERRORMessage;

public class LapTest {

    @Test
    @DisplayName("Lap 숫자 입력 확인 테스트")
    void 랩_숫자_생성_테스트() {
        //given
        int givenValue = 1;

        //when
        Lap lap = new Lap(givenValue);

        //then
        assertThat(lap).isEqualTo(new Lap(1));
    }

    @Test
    @DisplayName("Lap 문자 입력 확인 테스트 실패")
    void 랩_문자_생성_테스트_실패() {
        //given
        String givenValue = "문자";

        //when
        assertThatThrownBy(() -> new Lap(givenValue)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERRORMessage.LAP_VALIDATE_INTEGER);
    }

    @Test
    @DisplayName("Lap 문자 입력 확인 테스트 성공")
    void 랩_문자_생성_테스트_성공() {
        //given
        String givenValue = "1";

        //when
        Lap lap = new Lap(givenValue);

        //then
        assertThat(lap).isEqualTo(new Lap(1));
    }

    @Test
    @DisplayName("Lap 음수 입력 테스트")
    void 랩_음수_입력_테스트() {
        //given
        int givenValue = -1;

        //when, then
        assertThatThrownBy(() -> new Lap(givenValue)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                ERRORMessage.LAP_VALIDATE_POSITIVE);

    }

}
