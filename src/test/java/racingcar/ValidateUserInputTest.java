package racingcar;

import org.junit.jupiter.api.Test;

import racingcar.dto.Car;
import racingcar.dto.CarName;
import racingcar.dto.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidateUserInputTest {

    @Test
    void 자동차_이름_5자이하() {
        assertThat(new Car(new CarName("carNm"))).isNotNull();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(new CarName("carName"));
        });
    }

    @Test
    void 자동차_목록_쉼표구분() {
        String joinCars = "car1,car2,car3";

        Cars cars = new Cars();
        assertThat(cars.ready(joinCars)).isTrue();
    }

}
