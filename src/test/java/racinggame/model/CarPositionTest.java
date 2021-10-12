package racinggame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CarPosition Model 테스트")
class CarPositionTest {
    private CarPosition carPosition;

    @BeforeEach
    public void setUp() {
        carPosition = new CarPosition();
    }

    @Test
    @DisplayName("CarPosition 생성 확인")
    void createCarPosition() {
        // then
        assertAll(
                () -> assertThat(carPosition).isNotNull(),
                () -> assertThat(carPosition).isInstanceOf(CarPosition.class),
                () -> assertThat(carPosition.getPosition()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("CarPosition이 정상적으로 변경되는지 확인")
    void checkCarPositionForward() {
        // given // when
        carPosition.forward();

        // then
        assertAll(
                () -> assertThat(carPosition).isNotNull(),
                () -> assertThat(carPosition).isInstanceOf(CarPosition.class),
                () -> assertThat(carPosition.getPosition()).isEqualTo(1)
        );
    }
}
