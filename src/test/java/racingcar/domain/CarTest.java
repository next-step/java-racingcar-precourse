package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 자동차_정상_생성(final String input) {
        assertDoesNotThrow(() -> new Car(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "Raemerrr"})
    void 자동차_비정상_생성(final String input) {
        assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

    @Test
    void 자동차_전진_성공() {
        Car car = new Car("crong");
        car.racing(() -> true);
        assertThat(car.getDistance().intValue()).isEqualTo(1);
    }

    @Test
    void 자동차_전진_실패() {
        Car car = new Car("crong");
        car.racing(() -> false);
        assertThat(car.getDistance().intValue()).isEqualTo(0);
    }
}
