package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    @Test
    void testValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(null));
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(new ArrayList<>()));
    }

    @Test
    void testGetFarthestTraveledCars() {
        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Cars cars = new Cars(new ArrayList<>(Arrays.asList(car1, car2)));

        Cars farthestTravledCars1 = cars.getFarthestTraveledCars();
        assertThat(farthestTravledCars1.count()).isEqualTo(2);

        car2.travel();
        Cars farthestTravledCars2 = cars.getFarthestTraveledCars();
        assertThat(farthestTravledCars2.count()).isEqualTo(1);

        Car farthestTravledCar = farthestTravledCars2.get(0);
        assertThat(farthestTravledCar.getName().toString()).isEqualTo("woni");
    }
}
