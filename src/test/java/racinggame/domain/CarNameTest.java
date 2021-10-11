package racinggame.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("차 이름은 5자 이하로 생성할 수 있다")
    void create_car_name() {
        CarName carName = new CarName("shinh");

        assertThat(carName).isEqualTo(new CarName("shinh"));
    }

    @Test
    @DisplayName("차 이름이 5자를 초과할 시 Exception이 발생한다")
    void create_car_name_5_over() {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new CarName("shinhan");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }
}