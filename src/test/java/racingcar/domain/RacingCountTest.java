package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

/**
 * RacingCountTest
 *
 * @author suji
 * @date 2022-04-23
 **/
class RacingCountTest {

    @Test
    void 시도_횟수_공백_예외처리() {
        //given
        String inputCount = "";

        //when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCount(inputCount))
                .withMessage(ErrorMessage.ERROR_RACING_COUNT_EMPTY);

    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "0" })
    void 시도_횟수_잘못된_범위_입력_예외처리(String inputCount) {
        //given
        //when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCount(inputCount))
                .withMessage(ErrorMessage.ERROR_RACING_COUNT_RANGE);
    }

    @Test
    void 시도_횟수_최대값_초과_예외처리() {
        //given
        String inputCount = "2147483648";

        //when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCount(inputCount))
                .withMessage(ErrorMessage.ERROR_RACING_COUNT_MAX);
    }

    @Test
    void 시도_회차_완료_체크() {
        //given
        String inputCount = "5";
        RacingCount racingCount = new RacingCount(inputCount);
        int tryCount = 5;

        //when & then
        assertThat(racingCount.isEnd(tryCount)).isTrue();
    }

    @Test
    void 시도_회차_미완료_체크() {
        //given
        String inputCount = "5";
        RacingCount racingCount = new RacingCount(inputCount);
        int tryCount = 4;

        //when & then
        assertThat(racingCount.isEnd(tryCount)).isFalse();
    }

}