package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차 컬렉션 생성 테스트")
    @Test
    void create_car_collection() {
        Cars cars = new Cars(Arrays.asList(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        ));
    }

    @DisplayName("우승자 판별하기")
    @Test
    void racing_game_winner() {
        Cars cars = new Cars(mockCars());
        assertThat(cars.getWinner()).isEqualTo("car2,car3");
    }

    private List<Car> mockCars() {
        Car car1 = new Car("car1");
        car1.isMovable(1);
        car1.isMovable(0);

        Car car2 = new Car("car2");
        car2.isMovable(7);
        car2.isMovable(9);

        Car car3 = new Car("car3");
        car3.isMovable(6);
        car3.isMovable(4);

        return Arrays.asList(car1, car2, car3);
    }
}
