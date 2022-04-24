package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 자동차_이름은_1자_이상_5자_이하(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void random값이_4이상이면_전진() {
        Car car = new Car("hello");
        car.move();
        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }
}
