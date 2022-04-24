package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    private CarPosition carPosition;

    @BeforeEach
    void setUp() {
        carPosition = new CarPosition();
    }

    @Test
    @DisplayName("자동차 위치 생성 테스트")
    void carPositionTest() {
        assertThat(carPosition.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치 증가 테스트")
    void addCarPositionTest() {
        carPosition.forward(1);
        assertThat(carPosition.getPosition()).isEqualTo(1);
    }

}
