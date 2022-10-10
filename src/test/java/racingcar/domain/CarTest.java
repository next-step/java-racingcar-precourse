package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("move함수에_4이상_9이하_값이_들어오면_position_값_증가")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void move함수에_4이상_9이하_값이_들어오면_position_값_증가(int number) {
        Car car = new Car("test");
        Position expectedValue = new Position(1);

        car.move(number);
        assertThat(car.position()).isEqualTo(expectedValue);
    }

    @DisplayName("move함수에_0이상_3이하_값이_들어오면_position_값_동일")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void move함수에_0이상_3이하_값이_들어오면_position_값_동일(int number) {
        Car car = new Car("test");
        Position expectedValue = new Position(0);

        car.move(number);
        assertThat(car.position()).isEqualTo(expectedValue);
    }
}
