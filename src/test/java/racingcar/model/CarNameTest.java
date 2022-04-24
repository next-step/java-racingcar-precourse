package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void 자동차_이름_등록_성공() {
        // Given
        String carName = "pobi";
        // When
        CarName pobi = new CarName(carName);
        // Then
        assertThat(pobi.getCarName())
            .isNotEmpty()
            .isEqualTo(carName);
    }

    @Test
    void 자동차_이름_등록_공백실패() {
        // Given
        String carName = "";
        // When & Then
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage());
    }

    @Test
    void 자동차_이름_등록_5자이하실패() {
        // Given
        String carName = "pobiwo";
        // When & Then
        assertThatThrownBy(() -> new CarName(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.WRONG_CAR_NAME.getMessage());
    }
}
