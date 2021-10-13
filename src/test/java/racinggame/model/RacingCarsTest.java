package racinggame.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    void 우승자_확인_테스트() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 2);
        Car car3 = new Car("test3", 3);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        RacingCars testRacing = new RacingCars(carList);

        assertThat(testRacing.getWinner()).isEqualTo("최종 우승자는 test3 입니다.");
    }

    @Test
    void 다중_우승자_확인_테스트() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("test1", 1);
        Car car2 = new Car("test2", 3);
        Car car3 = new Car("test3", 3);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        RacingCars testRacing = new RacingCars(carList);

        assertThat(testRacing.getWinner()).isEqualTo("최종 우승자는 test2,test3 입니다.");
    }
}
