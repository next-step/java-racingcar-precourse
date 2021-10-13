package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.car.Car;
import racinggame.car.CarList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

    @Test
    void findWinnerTest() throws Exception {
        Car car1 = new Car("aba");
        car1.go(4);
        assertThat(car1.getCarProgress().get()).isEqualTo(1);
        Car car2 = new Car("queen");
        car2.go(3);
        assertThat(car1.getCarProgress().get()).isEqualTo(1);
        CarList carList = new CarList();
        carList.add(car1);
        carList.add(car2);
        assertThat(carList.getWinners()).contains("aba");
    }
}
