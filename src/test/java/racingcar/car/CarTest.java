package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.score.Score;

public class CarTest {

    @BeforeEach
    public void setUp() {

    }

    @DisplayName("자동차 멈춤 상태")
    @Test
    public void 자동차_멈춘다() {
        Car car = new Car(new Speed(3), new CarName("pobi"), new Score());
        Speed speed = car.getSpeed();
        assertThat(speed.isStop()).isTrue();
    }

    @Test
    @DisplayName("자동차 전진 상태")
    public void 자동차_전진() {
        Car car = new Car(new Speed(4), new CarName("jun"), new Score());
        Speed speed = car.getSpeed();
        assertThat(speed.isAdvance()).isTrue();
    }

}
