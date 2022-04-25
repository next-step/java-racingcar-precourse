package racingcar.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LapsTest {

    @DisplayName("몇 번의 이동을 할 것인지를 입력 받는다 1을 받았을때")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void set_laps(String number) {
        Laps laps = new Laps(number);
        assertThat(laps.getLapNumber()).isEqualTo(1);
    }

    @DisplayName("공백이면")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void set_laps_validtaion_empty(String number) {
        assertThatThrownBy(() -> {
        Laps laps = new Laps(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 필수 입니다.");
    }

    @DisplayName("숫자가 아닌경우 Exception 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1ㄲ11"})
    void set_laps_validtaion_number_type(String number) {
        assertThatThrownBy(() -> {
        Laps laps = new Laps(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능 합니다.");
    }



}
