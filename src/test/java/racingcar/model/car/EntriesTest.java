package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.racing.RacingStatus;
import racingcar.model.racing.RacingStrategy;
import racingcar.model.record.CarRecords;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EntriesTest {
    @Test
    @DisplayName("자동차 엔트리를 생성하고 경주한다.")
    void createEntries() {
        // given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
        RacingStrategy racingStrategy = () -> RacingStatus.GO;

        // when
        Entries entries = new Entries(cars);

        // then
        assertDoesNotThrow(() -> entries.race(racingStrategy));
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
        Entries entries = new Entries(cars);
        CarRecords carRecords = entries.convertCarRecords();

        // then
        assertThat(carRecords.size()).isEqualTo(3);
    }
}
