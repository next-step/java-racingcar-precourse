package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("객체가 생성될 때 필요한 파라미터의 유효성 검사")
    public void 자동차_객체_생성_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
    }

    @Test
    @DisplayName("자동차의 주행거리의 변화")
    public void 자동차의_주행거리를_변화시킨다() {
        Car car = new Car(new CarName("test"));
        car.changeDistance(new CarBehavior(4));

        assertEquals(car.getDistanceCount(), 1);
    }

    @Test
    @DisplayName("자동차의 각 차수별 실행결과 출력")
    public void 자동차의_차수별_실행결과_출력() {
        Car car = new Car(new CarName("test"));
        car.changeDistance(new CarBehavior(4));
        car.changeDistance(new CarBehavior(4));

        assertEquals(car.getCurrentStatusToString(), "test : --");
    }

}
