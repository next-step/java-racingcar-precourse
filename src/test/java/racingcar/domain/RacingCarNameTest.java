package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Messages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RacingCarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "ABCDE"})
    void 자동차_이름_설정(String input) {
        RacingCarName racingCarName = new RacingCarName(input);

        Assertions.assertThat(racingCarName.getName()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"counting_car", "javaji"})
    void 자동차_이름_초과_에러(String input) {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCarName(input))
                .withMessageContaining(Messages.EXCEED_CAR_NAME_MAX_LENGTH);
    }

    @Test
    void 자동차_이름_공백_설정_불가() {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCarName(""))
                .withMessageContaining(Messages.CAR_NAME_NOT_EMPTY);
    }

    @Test
    void 자동차_이름_개행문자_설정_불가() {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCarName(" "))
                .withMessageContaining(Messages.CAR_NAME_NOT_EMPTY);
    }

    @Test
    void 자동차_이름_NULL_불가() {
        // then
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new RacingCarName(null))
                .withMessageContaining(Messages.CAR_NAME_NOT_NULL);
    }
}
