package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    void 자동차_3대가_똑같이_움직이면_공동_우승이다() {
        Cars cars = new Cars(Arrays.asList("pobi", "woni", "junsu"));
        cars.move(() -> true);
        assertThat(cars.findWinnerCars().size()).isEqualTo(3);
    }
}
