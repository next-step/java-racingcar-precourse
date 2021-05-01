import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("Car_전진_테스트")
    void carMoveTest() {
        Car car = new Car("test");
        car.setCarStatus(CarStatus.MOVE);
        assertThat(car.getMoveCount().getCount()).isEqualTo(1);

        car.setCarStatus(CarStatus.STOP);
        assertThat(car.getMoveCount().getCount()).isEqualTo(1);
    }
}
