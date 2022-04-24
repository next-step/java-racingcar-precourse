package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.DisplayedParameterizedTest;
import racingcar.car.Car;

class RacingLineTest {

    @Test
    void 레이싱_라인_생성_테스트() {
        Car car = new Car("car");
        RacingLine racingLine = new RacingLine(car);

        assertThat(racingLine.getRacingCar()).isEqualTo(car);
        assertThat(racingLine.getPosition()).isEqualTo(0);
    }

    @Test
    void 레이싱_라인_생성_예외_테스트() {
        assertThatThrownBy(() -> new RacingLine(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 null 일 수 없습니다");
    }

    @DisplayedParameterizedTest
    @CsvSource({"0, 0", "3, 0", "4, 1", "9, 1"})
    void 전진_테스트(int random, int expected) {
        Car car = new Car("car");
        RacingLine racingLine = spy(new RacingLine(car));
        when(racingLine.getRandom()).thenReturn(random);

        racingLine.goStraight();

        assertThat(racingLine.getPosition()).isEqualTo(expected);
    }
}