package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.domain.Car;
import racingcar.car.domain.CarName;
import racingcar.car.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("이동 전략")
class MoveStrategyTest {

    @DisplayName("이동")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "9"})
    void move(int randomNumber) {
        Car car = new Car(new CarName("람보르기니"), new CarPosition());
        car.move(randomNumber);
        assertThat(car.carPosition()).isEqualTo(new CarPosition(1));
    }

    @DisplayName("이동 안함")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "10"})
    void notMove(int randomNumber) {
        Car car = new Car(new CarName("람보르기니"), new CarPosition());
        car.move(randomNumber);
        assertThat(car.carPosition()).isEqualTo(new CarPosition());
    }
}
