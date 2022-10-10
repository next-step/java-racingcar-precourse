package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {


    @Test
    @DisplayName("자동차 생성")
    void successCarName() {

        CarName carName = new CarName("CAR1");
        String name = carName.getName();
        assertThat(name).isEqualTo("CAR1");
    }

    @Test
    @DisplayName("자동차 이름 5자리 넘을 시 에러발생")
    void overMaxCarNameLength() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 공백으로 등록 시 에러발생")
    void emptyName() {
        assertThatThrownBy(() -> {
            CarName carName = new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}