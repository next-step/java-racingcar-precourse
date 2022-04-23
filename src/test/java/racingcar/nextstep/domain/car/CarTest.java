package racingcar.nextstep.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.nextstep.domain.racing.chart.RacingChart;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Car car = Car.of(CarName.of("aaa"));

    @Test
    void racing() {
        //given && when
        for (int i = 0; i < 100; i++) {
            car.racing();
        }
        //then
        assertThat(car.getCarPosition().getValue()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("레이싱 결과표를 만드는 테스트 코드")
    void createRacingChart() {
        //given
        car.inputCarPosition(CarPosition.addValue(3));
        //when
        final RacingChart racingChart = car.createRacingChart();
        //then
        assertThat(racingChart.getCar().getCarName().getValue()).isEqualTo(car.getCarName().getValue());
        assertThat(racingChart.getResult()).isEqualTo("----");
    }
}
