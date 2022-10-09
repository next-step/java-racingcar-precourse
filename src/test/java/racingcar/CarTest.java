package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("자동차"), new Position(0));
    }

    @Test
    void 이름_길이_1자_이상_5자_이하() {
        assertThatNoException()
                .isThrownBy(() -> car = new Car(new Name("가"), new Position(0)));
        assertThatNoException()
                .isThrownBy(() -> car = new Car(new Name("가나다라마"), new Position(0)));
    }

    @Test
    void 이름_길이_0인_문자열_예외() {
        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_길이_5자_이상_예외() {
        assertThatThrownBy(() -> new Name("가나다라마바"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 전진_판단() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 멈춤_판단() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
