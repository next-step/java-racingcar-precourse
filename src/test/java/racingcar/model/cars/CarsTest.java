package racingcar.model.cars;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.model.cars.factory.CarFactory;
import racingcar.model.cars.factory.Title;

public class CarsTest {
    @Test
    void 변환() {
        assertThat(Cars.of("123, 가나다라").get())
                .isEqualTo(Arrays.asList(
                        CarFactory.create(new Title("123")),
                        CarFactory.create(new Title(" 가나다라"))
                ));
    }
}
