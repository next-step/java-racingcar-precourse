package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {
    @Test
    @DisplayName("자동차_이름_5자_이하_검증_에러")
    void car_name_test_less_than_5_characters_valid_error() {
        assertThatThrownBy(() -> new CarName("sonata"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하로 입력하세요.");
    }

    @Test
    @DisplayName("자동차_이름_공백_에러")
    void car_name_test_is_blank_valid_error() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.(공백 불가)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "we", "leo", "tony", "crong"})
    @DisplayName("자동차_이름_5자_이하_검증_성공")
    void car_name_test_less_than_5_characters_valid_success(String name) {
        CarName carName = new CarName(name);
        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }
}
