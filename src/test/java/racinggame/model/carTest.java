package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class carTest {
    @Test
    @DisplayName("자동차_이동여부_판단")
    void 이동여부_판단() {
        assertThat(Car.judgeMoving(9)).isEqualTo(CarStatus.GO);
        assertThat(Car.judgeMoving(4)).isEqualTo(CarStatus.GO);
        assertThat(Car.judgeMoving(3)).isEqualTo(CarStatus.STOP);
        assertThat(Car.judgeMoving(1)).isEqualTo(CarStatus.STOP);
    }

    @Test
    @DisplayName("자동차_전진")
    void 전진() {
        Car car = new Car("Test");
        assertThat(car.getPosition()+1).isEqualTo(car.move(CarStatus.GO));
    }

    @Test
    @DisplayName("자동차_정지")
    void 정지() {
        Car car = new Car("Test");
        assertThat(car.getPosition()).isEqualTo(car.move(CarStatus.STOP));
    }
}
