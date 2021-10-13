package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("자동차 이름이 중복되었는지 확인")
    @Test
    void checkDuplicateCarName() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("Car1")));
        cars.add(new Car(new CarName("Car1")));

        assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동자 이름이 중복되었습니다.");
    }
}
