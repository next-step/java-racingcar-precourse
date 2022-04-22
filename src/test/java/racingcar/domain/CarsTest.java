package racingcar.domain;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void Test() {
        Cars cars = new Cars("a,b,c,d");

        cars.tryMove();
    }

    @Test
    public void 최장거리() {
        Cars cars = new Cars("a,b,c,d");

        cars.tryMove();
        cars.tryMove();
        cars.tryMove();
        cars.tryMove();

        int furthestPositionValue = cars.getFurthestPositionValue();
        System.out.println(furthestPositionValue);
        assertThat(furthestPositionValue).isLessThan(4);
    }
}
