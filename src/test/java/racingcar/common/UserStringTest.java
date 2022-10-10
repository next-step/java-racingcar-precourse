package racingcar.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserStringTest {

    @Test
    @DisplayName("공백은 trim되어서 입력됨")
    void test3() {
        UserString of = UserString.of("  car  ");

        assertThat(of.equals(UserString.of("car"))).isTrue();
    }

    @Test
    @DisplayName("null 이 입력되면 IllegalArgumentException이 발생함")
    void test2() {
        assertThatThrownBy(() -> UserString.of(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("UserString을 Split하면 2개의 배열이 반환됨")
    void test1() {
        UserString of = UserString.of("car1,car2");

        UserString[] split = of.split();

        assertThat(split.length).isEqualTo(2);
    }
}