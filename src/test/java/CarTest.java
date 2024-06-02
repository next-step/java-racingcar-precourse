import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CarTest {
    @Test
    void LENGTH_EXCEPTION() {
        assertThatThrownBy(() -> new Car("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @Test
    void MOVE_TEST() {
        Car car = new Car("pobi");
        car.makeMove();
        assertThat(car.getPosition()).isBetween(0, 1);
    }

}
