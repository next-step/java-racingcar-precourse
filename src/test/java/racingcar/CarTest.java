package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름_5자이하_유효성_테스트() {
        assertThatThrownBy(() -> new Car("hyndai")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_0자이상_유효성_테스트() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
    }
}
