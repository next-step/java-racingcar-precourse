package racingcar.game;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputRoundCountTest {

    @Test
    @DisplayName("사용자 입력 시도 횟수 생성 성공 테스트")
    void valueOf() {
        // given
        final String roundCountString = "5";
        final int roundCount = parseInt(roundCountString);

        // when
        final InputRoundCount inputRoundCount = InputRoundCount.valueOf(roundCountString);

        // then
        assertThat(inputRoundCount.getRoundCount()).isEqualTo(roundCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "asdasd", "#$$%234", "-2", "0", "2.54"})
    @DisplayName("사용자 입력 시도 횟수 생성 실패 테스트")
    void valueOf_exception(String roundCountString) {
        // given

        // when & then
        assertThatThrownBy(() -> InputRoundCount.valueOf(roundCountString))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("시도 횟수 만큼 반복 성공 테스트")
    void mapTimes() {
        // given
        final String roundCountString = "5";
        final int roundCount = parseInt(roundCountString);
        final InputRoundCount inputRoundCount = InputRoundCount.valueOf(roundCountString);

        final int initialValue = 1;
        final AtomicInteger expect = new AtomicInteger(initialValue);

        // when
        inputRoundCount.mapTimes(expect::getAndIncrement);

        // then
        assertThat(expect.get()).isEqualTo(initialValue + roundCount);
    }
}