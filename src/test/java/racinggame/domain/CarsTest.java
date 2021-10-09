package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("자동차 여러 건 생성 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1", "1,2,3"})
    void constructCars_success(String carsStr) {
        assertThat(new Cars(carsStr).getSize()).isEqualTo(carsStr.split(",").length);
    }

    @DisplayName("자동차들 이동 후 우승자 제대로 불러오는지 확인")
    @Test
    void moveForwardOrStopAndFindWinners_success() {
        Cars cars = new Cars("1,2,3");

        cars.moveForwardOrStop(0, MoveStatus.FORWARD);
        cars.moveForwardOrStop(1, MoveStatus.FORWARD);
        cars.moveForwardOrStop(2, MoveStatus.STOP);

        Winners winners = new Winners(Arrays.asList("1", "2"));
        assertThat(cars.findWinners()).isEqualTo(winners);
    }
}
