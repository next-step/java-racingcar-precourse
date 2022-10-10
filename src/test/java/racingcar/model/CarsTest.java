package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMove;

class CarsTest {

    @Test
    void 자동차_리스트_정상_생성() {
        Cars cars = Cars.of(new String[] {"test1", "test2", "test3"}, new AlwaysMove());

        assertThat(cars.getResults().size()).isEqualTo(3);
    }
}