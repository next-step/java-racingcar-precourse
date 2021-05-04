import controller.CarController;
import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class CarControllerTest {
    @Test
    public void splitByComma() {
        String value = "test,code";
        String[] values = CarController.splitByComma(value);

        assertThat(values.length).isEqualTo(2);
    }

    @Test
    public void generateCars() {
        String value = "test,code";
        List<Car> carList = CarController.generateCars(value);

        assertThat(carList.get(0).getName()).isEqualTo("test");
        assertThat(carList.get(1).getName()).isEqualTo("code");
    }
}
