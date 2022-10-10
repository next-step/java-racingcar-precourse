package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.Car.SEPARATOR;
import static racingcar.domain.car.move.Move.MOVE_FORWARD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.move.DefaultMove;

class CarTest {

    Car car;
    String name = "pobi";

    @BeforeEach
    void beforeEach() {
        CarName carName = new CarName(name, new DefaultCarNameValidator());
        car = new Car(carName, new DefaultMove());
    }

    @ParameterizedTest
    @DisplayName("전진->정지->전진")
    @CsvSource(value = "4:3:9", delimiter = ':')
    void move_forward_stop(int move1, int stop, int move2) {
        assertThat(car.move(move1)).isEqualTo(name + SEPARATOR + MOVE_FORWARD);
        assertThat(car.move(stop)).isEqualTo(name + SEPARATOR + MOVE_FORWARD);
        assertThat(car.move(move2)).isEqualTo(name + SEPARATOR + MOVE_FORWARD + MOVE_FORWARD);
    }

    @Test
    void stop() {
        assertThat(car.move(3)).isEqualTo(name + SEPARATOR);
    }

    @Test
    void move_forward() {
        assertThat(car.move(4)).isEqualTo(name + SEPARATOR + MOVE_FORWARD);
    }
}