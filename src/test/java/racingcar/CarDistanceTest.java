package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDistance;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarDistanceTest {

    @Test
    @DisplayName("자동차 거리 초기화 검증")
    public void 자동차_거리_검증() {
        assertThat(new CarDistance().getDistance()).isEqualTo(0);
    }
}
