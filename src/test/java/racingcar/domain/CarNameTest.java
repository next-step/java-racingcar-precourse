package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.Test;

class CarNameTest {
    @Test
    void 자동차의_이름은_공백일_수_없다() {
        assertThatCode(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 공백일 수 없습니다.");
    }

    @Test
    void 자동차의_이름은_5글자를_초과할_수_없다() {
        assertThatCode(() -> new CarName("abcCar"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차의 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차의_이름이_같을_경우_equals_는_True() {
        assertThat(new CarName("car")).isEqualTo(new CarName("car"));
    }

    @Test
    void 자동차의_이름이_다를_경우_equals_는_False() {
        assertThat(new CarName("car")).isNotEqualTo(new CarName("rac"));
    }

    @Test
    void CarName_toString_호출시_자동차_이름이_출력된다() {
        CarName carName = new CarName("sun");
        assertThat(carName.toString()).contains("sun");
    }
}