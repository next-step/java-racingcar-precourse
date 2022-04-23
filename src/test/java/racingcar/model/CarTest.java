package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.common.ErrorMessage.NAME_TO_LONG;

public class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        String testName = "test";
        Car car = Car.create(testName);
        assertThat(car.getName()).isEqualTo(testName);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 테스트")
    void carNameTooLongTest() {
        String tooLongName = "testCa";
        assertThatIllegalArgumentException()
                .isThrownBy(()->Car.create(tooLongName))
                .withMessage(NAME_TO_LONG.text());
    }

}
