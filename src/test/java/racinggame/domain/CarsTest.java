package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @DisplayName("자동차 여러 건 생성 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1", "1,2,3"})
    void constructCars_success(String carsStr) {
        assertThat(new Cars(carsStr).getSize()).isEqualTo(carsStr.split(",").length);
    }
}
