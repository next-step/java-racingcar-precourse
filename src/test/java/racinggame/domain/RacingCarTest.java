package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = new RacingCar(new Name("lewis"));
    }

    @DisplayName("자동차를 생성할 수 있다.")
    @Test
    void create() {
    }

    @DisplayName("값이 4 이상일 경우 자동차는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveForward(final int value) {
        car.move(value);
        final Position expected = new Position(1);
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("값이 3 이하일 경우 자동차는 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(final int value) {
        car.move(value);
        final Position expected = new Position();
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차가 전진 또는 멈춤을 판단하려면 입력 받는 값이 0 이상, 9 이하 범위내의 값이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void invalidValue(final int value) {
        assertThatThrownBy(
            () -> car.move(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
