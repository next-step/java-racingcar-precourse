package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RacingCarUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    @Test
    public void 자동차_리스트_스필릿_검증() {
        String input = "woodi,pubi,momo";
        String[] arrList = RacingCarUtils.splitName(input);

        for (Car car : new Cars(input).getCarList()) {
            assertThat(arrList).contains(car.getName());
        }
    }
}
