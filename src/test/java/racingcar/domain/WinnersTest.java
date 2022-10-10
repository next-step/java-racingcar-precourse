package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("우승 자동차 도메인 테스트")
class WinnersTest {

    @Test
    @DisplayName("우승 자동차 생성 성공")
    void constructor() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car1.control(ControlType.FORWARD);
        car2.control(ControlType.FORWARD);
        car3.control(ControlType.STOP);

        // when
        Winners winners = new Winners(Arrays.asList(car1, car2, car3));

        // then
        assertAll(
                () -> assertThat(winners.getCarCount()).isEqualTo(2),
                () -> assertThat(winners.getCar(0)).isEqualTo(car1),
                () -> assertThat(winners.getCar(1)).isEqualTo(car2)
        );
    }
}
