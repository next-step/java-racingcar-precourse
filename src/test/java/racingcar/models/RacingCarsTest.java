package racingcar.models;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exceptions.IllegalArgumentException;

public class RacingCarsTest {

    @Test
    @DisplayName("레이싱에 출전하는 차가 한 대도 없을 때, 오류가 발생하는가")
    void error_no_cars() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                RacingCars cars = new RacingCars(new ArrayList<Car>());
            })
            .withMessageContaining("레이싱을 하려면 1대 이상의 자동차가 필요해요.")
            .withMessageContaining("[ERROR]");

    }
}
