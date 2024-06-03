package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    public void constructorTest() {
        Car car = new Car("mjack");
        assertThat(car.getName()).isEqualTo("mjack");
    }

    @Test
    public void invalidNameException() {
        assertThatThrownBy(() -> new Car("longname"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moveTest() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
