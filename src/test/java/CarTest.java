import static org.assertj.core.api.Assertions.assertThat;

import Model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {

    @Test
    @DisplayName("carMoveForwardTest")
    public void carMoveForwardTest(){
        Car car = new Car("hello");

        car.moveForward();

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
