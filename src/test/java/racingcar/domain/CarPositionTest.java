package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.domain.CarPositionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarPositionTest {

    CarPosition carPosition;

    @BeforeEach
    void setUp(){
     carPosition = new CarPosition(3);
    }

    @Test
    void createCarPosition() {
        assertThat(carPosition.getPosition()).isEqualTo(3);
    }

    @Test
    void addCarPosition() {
        carPosition.addPosition();
        assertThat(carPosition.getPosition()).isEqualTo(4);
    }

    @Test
    void printCarPosition() {
        assertThat(carPosition.print()).isEqualTo("---");
    }

    @Test
    @DisplayName("위치값이 0보다 작을 경우 예외 발생")
    void validatePositionUnderZero() {
        assertThatThrownBy(() -> {
            new CarPosition(-1);
        }).isInstanceOf(CarPositionException.class)
          .hasMessageContaining("후진");
    }

}