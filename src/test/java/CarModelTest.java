import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarModelTest {

    @Test
    public void generateCarTest() {
        Car car = new Car("test_car");
        String carName = car.getCarName();
        int moveCount = car.getMoveCount();
        assertThat(carName.equals("test_car") && moveCount == 0).isTrue();
    }
}
