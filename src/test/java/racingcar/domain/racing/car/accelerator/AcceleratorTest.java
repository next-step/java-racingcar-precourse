package racingcar.domain.racing.car.accelerator;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.racing.constant.TestConstant.MOVING_FORWARD;
import static racingcar.domain.racing.constant.TestConstant.ORIGINAL_LOCATION;
import static racingcar.domain.racing.constant.TestConstant.STOP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Location;

public class AcceleratorTest {
    private Location initialLocation;

    @BeforeEach
    void setUp() {
        initialLocation = Location.from(ORIGINAL_LOCATION);
    }

    @Test
    @DisplayName("자동차를 이동시킨다")
    void 자동차를_이동시킨다() {
        Accelerator accelerator = Accelerator.from(MOVING_FORWARD);
        assertThat(accelerator.moveCar(initialLocation)).isNotNull().isNotEqualTo(initialLocation);
    }

    @Test
    @DisplayName("자동차를 이동시키지 않는다")
    void 자동차를_이동시키지_않는다() {
        Accelerator accelerator = Accelerator.from(STOP);
        assertThat(accelerator.moveCar(initialLocation)).isNotNull().isEqualTo(initialLocation);
    }
}
