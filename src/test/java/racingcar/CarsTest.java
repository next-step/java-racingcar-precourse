package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("차량들 테스트")
public class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        CarNames carNames = new CarNames("pobi,crong,honux");
        cars = new Cars(carNames);

        cars.cars.get(0).goForward(true);
        cars.cars.get(0).goForward(true);
        cars.cars.get(1).goForward(true);
    }

    @Test
    @DisplayName("누가 우승자인지 알아보는 테스트")
    void whoIsWinner() {
        assertThat(cars.whoIsWinner()).isEqualTo("pobi");
    }

}
