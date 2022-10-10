package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoundNumberTest {

    @DisplayName("라운드_숫자_정상_입력")
    @ParameterizedTest
    @CsvSource(value = {"1", "10", "1000"}, delimiter = ':')
    void 라운드_숫자_정상_입력(String roundNumber) {
        assertThatNoException().isThrownBy(() -> new RoundNumber(roundNumber));
    }

    @DisplayName("라운드_숫자_아니면_에러")
    @ParameterizedTest
    @CsvSource(value = {",", "a", "a1"}, delimiter = ':')
    void 라운드_숫자_아니면_에러(String roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber(roundNumber));
    }

    @DisplayName("라운드_숫자_0_미만이면_에러")
    @ParameterizedTest
    @CsvSource(value = {"-1", "-1000"}, delimiter = ':')
    void 라운드_숫자_0_미만이면_에러(String roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundNumber(roundNumber));
    }

    @DisplayName("마지막_라운드_체크")
    @ParameterizedTest
    @CsvSource(value = {"5:0:false", "5:5:true"}, delimiter = ':')
    void 마지막_라운드_체크(String roundNum, String currentNum, boolean result) {
        RoundNumber roundNumber = new RoundNumber(roundNum);
        assertThat(roundNumber.isFinalRoundNumber(new RoundNumber(currentNum))).isEqualTo(result);
    }

    @DisplayName("plus_함수_체크")
    @Test
    void plus_함수_체크() {
        RoundNumber roundNumber = new RoundNumber();
        roundNumber.plus();
        assertThat(roundNumber).isEqualTo(new RoundNumber("1"));
    }
}
