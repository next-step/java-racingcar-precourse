import Model.Car;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("car1");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
