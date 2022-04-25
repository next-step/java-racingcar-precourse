package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차_주행거리_표시_테스트")
    void 자동차_주행거리_표시_테스트() {

        Car car = new Car("krad");

        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.mileage.mileage()).isGreaterThan(0).isEqualTo(1);
                    assertThat(output()).contains("krad : -");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {

    }
}
