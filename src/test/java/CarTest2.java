

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest2 {

    @Test
    void 자동차_이름이_유효한_경우() {
        Car car =     new Car("민성");
        assertThat(car.getName()).isEqualTo("민성");
    }

    @Test
    void 자동차_이름이_null인_경우_예외처리() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 자동차_이름이_5자를_초과하는_경우_예외처리() {
        assertThatThrownBy(() -> new Car("pobi123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 자동차_이름이_1자_미만인_경우_예외처리() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    /*@Test
    void 자동차가_전진하는_경우() {
        Car car = new Car("민성");
        car.run(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차가_멈추는_경우() {
        Car car = new Car("민성");
        car.run(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }
    */

}

