package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주의 자동차 테스트")
public class CarTest {

    @Test
    @DisplayName("자동차가 앞으로 나가는지 테스트")
    void goCar() {
        Car car = new Car(new CarName("pobi"));
        car.goForward(true);
        assertThat(car.nowPosition()).isEqualTo(1);
    }


}
