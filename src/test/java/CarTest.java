import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;
    @BeforeEach
    @DisplayName("초기화")
    void setUp() {
        car = new Car("testCar");
    }

    @Test
    @DisplayName("자동차가 정상적으로 전진하는지")
    void carMoveValid() {
        // when
        car.move();
        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}
