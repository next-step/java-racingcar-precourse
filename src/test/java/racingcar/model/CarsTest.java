package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static racingcar.common.type.CarPosition.MOVING_FORWARD;

class CarsTest {

    @Test
    @DisplayName("Cars 클래스를 정상적으로 생성해야 한다.")
    void createCars() {
        assertThatCode(() -> new Cars(new String[]{"a", "b", "c", "d"}))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("생성된 Cars 클래스에서 각각 move forward 를 수행해야 한다.")
    void moveForwardCars() {
        assertRandomNumberInRangeTest(() -> {
                    final Cars cars = new Cars(new String[]{"a", "b", "c", "d"});
                    cars.moveForwardRandom();
                    final List<Car> carList = cars.getCarList();
                    assertThat(carList)
                            .extracting("carPosition")
                            .containsExactly(1, 1, 0, 0);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD - 1, MOVING_FORWARD - 1
        );
    }

    @Test
    @DisplayName("생성된 Cars 클래스에서 각각 move forward 를 수행 후 winner를 뽑아내야 한다.")
    void winner() {
        assertRandomNumberInRangeTest(() -> {
                    final Cars cars = new Cars(new String[]{"a", "b", "c", "d"});
                    cars.moveForwardRandom();
                    final List<Car> highestScoreCars = cars.getHighestScoreCars();
                    assertThat(highestScoreCars)
                            .hasSize(2)
                            .extracting("carPosition")
                            .containsExactly(1, 1);
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD - 1, MOVING_FORWARD - 1
        );
    }
}