package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_숫자_3이하_정지() {
        Car car = new Car("junsu");
        car.move(() -> false);
        assertThat(car.isStop()).isTrue();
    }

    @Test
    void 자동차_숫자_4이상_전진() {
        Car car = new Car("junsu");
        car.move(() -> true);
        assertThat(car.isStop()).isFalse();
    }

    @Test
    void 자동차_이름은_5자리이하() {
        assertThatThrownBy(() -> {
            Car car = new Car("junsuu");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 이름은 5자리 이하만 가능합니다.");
    }
}
