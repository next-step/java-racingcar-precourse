package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("이름 0자리, 6자리일 경우 검증")
    public void 자동차_이름_길이_검증() {
        assertThatThrownBy(() -> {
            new Car("").getName();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    public void 자동차_전진_조건_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("woodi");
                    car.runRound();
                    assertThat(car.getDistance()).isEqualTo(1);
                },4
        );
    }

    @Test
    public void 자동차_멈춤_조건_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("woodi");
                    car.runRound();
                    assertThat(car.getDistance()).isEqualTo(0);
                },3
        );
    }
}
