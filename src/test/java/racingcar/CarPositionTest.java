package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    @DisplayName("4이상의 숫자가 입력되었을때 앞으로 전진")
    void moveForward(){
        CarPosition position = new CarPosition(0);
        position.updatePosition(4);
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하의 숫자가 입력되었을때 멈춤")
    void stop(){
        CarPosition position = new CarPosition(0);
        position.updatePosition(3);
        assertThat(position.getPosition()).isEqualTo(0);
    }

}
