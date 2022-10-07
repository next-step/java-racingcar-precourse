package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final String carName = "test1";
    private static final String overCarName = "tester";
    private static final String emptyName1 = "";
    private static final String emptyName2 = " ";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static Car car;

    @BeforeAll
    static void beforeAll() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("자동차 이름 입력")
    void input_carName() {
        assertThat(car.getName().equals(carName)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 길이 초과 검증")
    void carName_length5() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(overCarName))
                .withMessageContaining("초과");
    }

    @Test
    @DisplayName("자동차 이름 미입력 검증")
    void carName_length0() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(emptyName1))
                .withMessageContaining("미입력");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(emptyName2))
                .withMessageContaining("미입력");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(null))
                .withMessageContaining("미입력");
    }
    @Test
    @DisplayName("자동차 이동 테스트")
    void input_Car_Move() {
        car.move(STOP);
        assertThat(car.getDistance()).isEqualTo(0);

        car.move(MOVING_FORWARD);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
