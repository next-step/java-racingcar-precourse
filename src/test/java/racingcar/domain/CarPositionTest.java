package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {
    private CarPosition carPosition;

    @BeforeEach
    public void setUp() {
        carPosition = new CarPosition();
    }

    @Test
    @DisplayName("CarPosition 생성 확인")
    void createCarPosition() {
        assertThat(carPosition.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("4 이상의 숫자가 입력되었을 시 전진하는지 확인")
    void checkCarPositionForward() {
        carPosition.forward(4);

        assertThat(carPosition.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4 이상의 숫자가 입력되었을 시 멈춰있는지 확인")
    void checkCarPositionStop() {
        carPosition.forward(3);

        assertThat(carPosition.getPosition()).isEqualTo(0);
    }
}
