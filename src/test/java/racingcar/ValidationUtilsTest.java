package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 체크 - 적절한 이름")
    @ValueSource(strings = {"pobi", "racer"})
    void validateName_valid(String name) {
        assertThat(ValidationUtils.isValidName(name)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 체크 - 부적절한 이름")
    @ValueSource(strings = {"Lightning", "Invalid"})
    void validateName_invalid(String name) {
        assertThat(ValidationUtils.isValidName(name)).isFalse();
    }

    @Test
    @DisplayName("게임이 시작 가능한지 체크")
    void isPlayable_Enable() {
        Cars cars = new Cars(new String[] {"pobi", "honux", "crong"});
        assertThat(ValidationUtils.isPlayable(cars)).isTrue();
    }

    @Test
    @DisplayName("시작 불가능한 게임")
    void isPlayable_Disable() {
        Cars cars = new Cars(new String[] {"pobi", "rightning", "tadada"});
        assertThat(ValidationUtils.isPlayable(cars)).isFalse();
    }
}
