package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int MOVABLE_NUM = 4;

    @DisplayName("랜덤값이 4 이상일 경우 자동차는 전진한다.")
    @Test
    public void carMoveTest_Forward() {
        MoveStrategy moveStrategy = () -> RandomNumber.generate(4, 9) >= MOVABLE_NUM;
        Car car = new Car("test");
        car.move(moveStrategy);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 3 이하일 경우 자동차는 정지한다.")
    @Test
    public void carMoveTest_Stop() {
        MoveStrategy moveStrategy = () -> RandomNumber.generate(0, 3) >= MOVABLE_NUM;
        Car car = new Car("test");
        car.move(moveStrategy);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}