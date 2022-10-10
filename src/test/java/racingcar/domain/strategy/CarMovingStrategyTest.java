package racingcar.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.CarStatus;
import racingcar.domain.strategy.CarMovingStrategy;
import racingcar.domain.strategy.MovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4이상일 경우 전진한다.")
    void moveCar(int randomNumber) {
        //given
        MovingStrategy carMovingStrategy = new CarMovingStrategy();

        //when
        CarStatus carStatus = carMovingStrategy.getMoveStatus(randomNumber);

        //then
        assertThat(carStatus).isEqualTo(CarStatus.MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 3이하일 경우 정지한다.")
    void stopCar(int randomNumber) {
        //given
        MovingStrategy carMovingStrategy = new CarMovingStrategy();

        //when
        CarStatus carStatus = carMovingStrategy.getMoveStatus(randomNumber);

        //then
        assertThat(carStatus).isEqualTo(CarStatus.STOP);
    }
}
