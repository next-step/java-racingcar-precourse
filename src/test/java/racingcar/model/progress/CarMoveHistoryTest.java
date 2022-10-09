package racingcar.model.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import racingcar.model.cars.Car;
import racingcar.model.cars.factory.MoveHistory;
import racingcar.model.cars.factory.Title;

public class CarMoveHistoryTest {
    @Test
    void 변환() {
        Title expectedTitle = new Title("");
        MoveHistory moveHistory = new MoveHistory();
        Car car = mock(Car.class);
        when(car.getTitle()).thenReturn(expectedTitle);
        when(car.getMoveHistory()).thenReturn(moveHistory);

        CarMoveHistory carMoveHistory = CarMoveHistory.of(car);
        assertThat(carMoveHistory.getTitle()).isEqualTo(expectedTitle);
        assertThat(carMoveHistory.getMoveHistory()).isEqualTo(moveHistory);
    }
}
