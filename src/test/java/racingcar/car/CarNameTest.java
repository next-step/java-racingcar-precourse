package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @DisplayName("자동차 이름 등록 실패(공백 문자열)")
    @ParameterizedTest
    @ValueSource(strings = {"    "})
    public void fail_regist_cart_name_is_empty(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class).hasMessage(CarErrorStatus.BLANK.printMessage());
    }

    @DisplayName("자동차 이름 등록 실패(5글자 초과)")
    @ParameterizedTest
    @ValueSource(strings = {"royalFamily"})
    public void fail_regist_cart_name_over_length(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class).hasMessage(CarErrorStatus.NAME_OVER_LENGTH.printMessage());
    }

    @DisplayName("자동차 이름 등록")
    @ParameterizedTest
    @ValueSource(strings = {"GV700", "G", "GV", "GV7", "GV70"})
    public void success_resist_car_name(String name) {
        assertThatCode(() -> new CarName(name)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름 확인")
    @ParameterizedTest
    @ValueSource(strings = {"GV700", "G", "GV", "GV7", "GV70"})
    public void check_car_name(String name) {
        CarName carName = new CarName(name);
        assertThat(name).isEqualTo(carName.getName());
    }

}
