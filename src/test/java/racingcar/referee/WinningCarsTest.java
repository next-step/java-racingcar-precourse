package racingcar.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.domain.Car;
import racingcar.car.domain.CarName;
import racingcar.car.domain.CarPosition;
import racingcar.referee.domain.WinningCars;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("우승 자동차")
class WinningCarsTest {

    @DisplayName("우승 자동차 생성")
    @Test
    void createWinnerCars() {
        Car lamborghini = new Car(new CarName("람보르기니"), new CarPosition());
        WinningCars winningCars = new WinningCars();
        assertDoesNotThrow(() -> winningCars.add(lamborghini));
    }
}
