package racingcar.car;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest extends NsTest {
    Car car;

    @BeforeEach
    void setup() {
        car = new Car(new CarName("ray"));
    }

    @Test
    void 자동차_랜덤_전진시_위치_숫자_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.randomMove();
                    car.randomMove();
                    car.randomMove();
                    assertThat(car.getPosition().toNumber()).isEqualTo(2);
                },
                4, 5, 1
        );
    }

    @Test
    void 자동차_랜덤_전진시_위치_텍스트_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.randomMove();
                    car.randomMove();
                    car.randomMove();
                    assertThat(car.getPosition().toResultText()).isEqualTo("---");
                },
                4, 5, 9, 1, 2
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
