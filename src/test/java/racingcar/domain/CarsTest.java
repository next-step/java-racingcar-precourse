package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("validator 를 통과한 이름을 넘겨주면 Cars , Car 모두 정상적으로 생성되어야 한다")
    @Test
    void create_cars_test() {
        String carNames = "pobi, json, woob, bob, john";

        Cars cars = new Cars(carNames);
        List<Car> carList = cars.getCars();

        assertThat(cars.getCars().size()).isEqualTo(5);
        assertTrue(carNames.contains(carList.get(0).getName()));
        assertTrue(carNames.contains(carList.get(1).getName()));
        assertTrue(carNames.contains(carList.get(2).getName()));
        assertTrue(carNames.contains(carList.get(3).getName()));
        assertTrue(carNames.contains(carList.get(4).getName()));
    }
}
