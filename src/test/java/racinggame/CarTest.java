package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.MoveUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void go(){
        Car car = new Car("pobi");
        car.play(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }
    @Test
    void stop(){
        Car car = new Car("pobi");
        car.play(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
