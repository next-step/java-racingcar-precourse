package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    @Test
    @DisplayName("자동차_위치_생성")
    void create_car_position() {
        CarPosition carPosition = new CarPosition();
        assertThat(carPosition.getPosition()).isZero();
    }

    @Test
    @DisplayName("자동차_전진")
    void move_forward() {
        CarPosition carPosition = new CarPosition();
        carPosition.moveForward();
        assertThat(carPosition).isEqualTo(new CarPosition(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----", "5:-----"}, delimiter = ':')
    @DisplayName("자동차_위치_수_하이픈_반환")
    void car_position(int position, String hyphen) {
        CarPosition carPosition = new CarPosition(position);
        assertThat(carPosition.convertHyphen()).isEqualTo(hyphen);
    }
}
