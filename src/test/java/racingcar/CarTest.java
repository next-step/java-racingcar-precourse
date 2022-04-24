package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import enums.MovingStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Racing;

public class CarTest {
    private Car car;
    private Racing racing;

    @BeforeEach
    public void setCar() {
        this.car = new Car("ferra");
        this.racing = new Racing();
    }

    @Test
    public void moveCar() {
        MovingStatus movingStatus = racing.randomValue();
        if(movingStatus.isMovingForward()) {
            int location = car.moveCar(movingStatus);
            assertThat(movingStatus).isEqualTo(MovingStatus.MOVING_FORWARD);
            assertThat(location).isEqualTo(1);
        }
        if(movingStatus.isStop()) {
            int location = car.moveCar(movingStatus);
            assertThat(movingStatus).isEqualTo(MovingStatus.STOP);
            assertThat(location).isEqualTo(0);
        }
    }
}
