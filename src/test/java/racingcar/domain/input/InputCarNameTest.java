package racingcar.domain.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;
import static racingcar.type.ErrorMessageType.NOT_ALLOW_GREATER_THAN_FIVE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

class InputCarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"woo dy", " pobi", "jun "})
    @DisplayName("사용자가 입력한 값에 공백이 존재한다면 IllegalArgumentException 예외가 발생한다.")
    void input_notAllowNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new InputCarName(input);
                })
                .withMessageContaining(INPUT_NOT_ALLOW_BLANK.getMessage());
    }

    @Test
    @DisplayName("사용자가 입력한 자동차 이름의 길이가 5자 이하인지 확인한다.")
    void input_allowCarNameLengthLessThanFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Input<Cars> carsInput = new InputCarName("pobi,woni,stanley");
                    carsInput.create();
                })
                .withMessageContaining(NOT_ALLOW_GREATER_THAN_FIVE.getMessage());
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 쉼표(,) 기준으로 구분한다.")
    void input_split() {
        Input<Cars> carsInput = new InputCarName("pobi,woni,jun");
        Cars cars = carsInput.create();
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("jun");
    }
}