package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차_생성")
    void 자동차_생성() {
        String carName = "pobi";
        Car car = new Car(carName);
        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.getMovementCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차_이름_생성_실패")
    void 자동차_이름_생성_실패() {
        assertThatThrownBy(
                () -> new Car("")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CAR_NAME_EMPTY);
        assertThatThrownBy(
                () -> new Car("pobipobi")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_CAR_NAME_OVER_SIZE);
    }

}
