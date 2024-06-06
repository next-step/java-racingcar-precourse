import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;
    @BeforeEach
    @DisplayName("initialization")
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("car move test")
    void carMoveValid() {
        // when
        car.move();
        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}
