package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsFactoryTest {

    @Test
    @DisplayName("자동차 이름들 쉼표(,)를 기준으로 구분하여 자동차들 생성")
    void givenNames_ShouldCreatedCars() {
        String names = "pobi,crong,honux";
        List<Car> cars = CarsFactory.of(names);
        assertThat(cars).hasSize(3);
    }
}
