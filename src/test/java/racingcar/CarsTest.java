package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("일급콜렉션 Cars가 잘 구현되는지 검증")
    void makeCar() {
        Car car1 = new Car("shin");
        Car car2 = new Car("han");

        List<Car> carList = Arrays.asList(car1, car2);
        Cars cars = new Cars(Arrays.asList(car1, car2));

        assertThat(cars.getCars().get(0)).isEqualTo(carList.get(0));
        assertThat(cars.getCars().get(1)).isEqualTo(carList.get(1));

        assertThat(cars.getCars().get(0).getName()).isEqualTo("shin");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("han");
    }
}
