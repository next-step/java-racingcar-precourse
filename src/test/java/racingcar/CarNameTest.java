package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("자동차 클래스의 필드변수 클래스인 carname 클래스에 대한 테스트. ")
    void carNameTest() {
        CarName carname = new CarName("felix");
        assertThat(carname instanceof CarName).isTrue();
        assertThat(carname.getName().length()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름은 5자 이내만 가능하며, 5자를 초과할 경우 illegalArgumentException을 발생시킨다.")
    void carNameValidationTest() {
        assertThatThrownBy(() -> {
            new CarName("felix1");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

}
