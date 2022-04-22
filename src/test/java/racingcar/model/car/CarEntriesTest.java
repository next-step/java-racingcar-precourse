package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarRecordDto;
import racingcar.model.movement.MovementStatus;
import racingcar.model.movement.MovementStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarEntriesTest {
    @Test
    @DisplayName("자동차 엔트리를 생성하고 경주한다.")
    void createEntries() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        MovementStrategy movementStrategy = () -> MovementStatus.GO;

        // when
        CarEntries carEntries = new CarEntries(cars);

        // then
        assertDoesNotThrow(() -> carEntries.race(movementStrategy));
    }

    @Test
    @DisplayName("자동차 엔트리로 자동차 기록을 생성한다.")
    void createCarRecords() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        // when
        CarEntries carEntries = new CarEntries(cars);
        List<CarRecordDto> carRecords = carEntries.convertCarRecords();

        // then
        assertThat(carRecords).hasSize(3);
    }
}
