package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LengthCarNameValidatorTest {

    private Integer maxLength = 5;
    CarNameValidator validator;

    @BeforeEach
    public void initValidator() {
        this.validator = new LengthCarNameValidator(maxLength);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름은 5자를 넘어가면 에러를 발생한다.")
    @ValueSource(strings = {"asdbdd", "dsadsad", "dsadsa", "dsadsad", "가나다라마사"})
    public void carNameLengthTest(String carName) {
        assertThatThrownBy(() -> this.validator.validCarName(new CarName(carName)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(maxLength + "자를");
    }

    @Test
    @DisplayName("자동차 이름은 비어있을 경우 에러를 발생한다.")
    public void carNameLengthTest() {
        String carName = "";
        assertThatThrownBy(() -> this.validator.validCarName(new CarName(carName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 이하일 경우 옳바르게 통과한다.")
    @ValueSource(strings = {"dsa", "yrwe", "vzcx", "pppo", "pals"})
    public void carNameLengthOkTest(String carName) {
        assertThatCode(() -> this.validator.validCarName(new CarName(carName)))
                .doesNotThrowAnyException();
    }


}