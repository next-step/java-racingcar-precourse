package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.move.Movement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarPositionTest {

    private static final int DEFAULT_POSITION = 0;
    private static final int INCREASE_POSITION_VALUE = 1;
    private Movement stopMove;
    private Movement goMove;

    @BeforeEach
    public void init() {
        this.stopMove = new Movement() {
            @Override
            public boolean isMoveAble() {
                return false;
            }

            @Override
            public int getIncreasePosition(int position) {
                return 1;
            }
        };
        this.goMove = new Movement() {
            @Override
            public boolean isMoveAble() {
                return true;
            }

            @Override
            public int getIncreasePosition(int position) {
                return INCREASE_POSITION_VALUE;
            }
        };
    }

    @Test
    @DisplayName("자동차 위치 생성")
    public void success_create_position() {
        assertThatCode(CarPosition::new).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 위치 초기값 확인(0)")
    public void check_position_default_value() {
        CarPosition carPosition = new CarPosition();
        assertThat(DEFAULT_POSITION).isEqualTo(carPosition.getPosition());
    }

    @Test
    @DisplayName("자동차 위치 증가(stop)")
    public void stop_position() {
        CarPosition carPosition = new CarPosition();
        carPosition.calculatePosition(stopMove);
        assertThat(DEFAULT_POSITION).isEqualTo(carPosition.getPosition());
    }

    @Test
    @DisplayName("자동차 위치 증가(increase)")
    public void increase_position() {
        CarPosition carPosition = new CarPosition();
        carPosition.calculatePosition(goMove);
        assertThat(INCREASE_POSITION_VALUE).isEqualTo(carPosition.getPosition());
    }
}
