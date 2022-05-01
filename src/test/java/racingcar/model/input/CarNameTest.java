package racingcar.model.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 1자 미만인 경우 IllegalArgumentException를 발생시킨다.")
    void validateCarNameMinLengthTest() {
        assertThatThrownBy(() -> {
            new CarName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 1자 이상 입력해주세요!");
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘는 경우 IllegalArgumentException를 발생시킨다.")
    void validateCarNameMaxLengthTest() {
        assertThatThrownBy(() -> {
            new CarName("Gosling");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하로 입력해주세요!");
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 필드 값으로 가진 객체가 정상적으로 생성되는지 확인한다.")
    void createCarNameWithInputNameTest() {
        assertThat(new CarName("park"))
                .isNotNull()
                .isExactlyInstanceOf(CarName.class)
                .hasFieldOrPropertyWithValue("name", "park");
    }

}