package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void init() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("honux"));
        cars = new Cars(carList);
    }

    @Test
    void 우승자_구하기() {
        List<Car> carList = this.cars.getCars();
        Car pobi = carList.get(0);
        Car crong = carList.get(1);
        Car honux = carList.get(2);

        pobi.move(() -> true);
        pobi.move(() -> true);

        crong.move(() -> true);
        crong.move(() -> true);

        assertThat(cars.findWinners()).isEqualTo(pobi.getCarName() + "," + crong.getCarName());
    }
}
