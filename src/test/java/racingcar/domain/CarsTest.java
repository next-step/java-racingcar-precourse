package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private final Standard STOP = new Standard(2);
    private final Standard MOVING_FORWARD = new Standard(6);

    @Test
    void 서로_다른_순서로_움직임_동일한_위치() {
        Cars cars = new Cars(Arrays.asList("yoshi", "kirby"));
        Position ONE = new Position(1);

        cars.tryToMove(new Standards(Arrays.asList(STOP, MOVING_FORWARD)));
        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, STOP)));
        cars.tryToMove(new Standards(Arrays.asList(STOP, STOP)));

        assertThat(cars.get(0).getPosition()).isEqualTo(ONE);
        assertThat(cars.get(1).getPosition()).isEqualTo(ONE);
    }

    @Test
    void 가장_멀리_간_차_1대() {
        Cars cars = new Cars(Arrays.asList("yoshi", "kirby", "mario"));

        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, STOP, STOP)));

        Cars winners = cars.getTheFarthest();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getPosition()).isEqualTo(new Position(3));
    }

    @Test
    void 가장_멀리_간_차_2대() {
        Cars cars = new Cars(Arrays.asList("yoshi", "kirby", "mario"));

        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, STOP)));
        cars.tryToMove(new Standards(Arrays.asList(MOVING_FORWARD, MOVING_FORWARD, STOP)));

        Cars winners = cars.getTheFarthest();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(1).getPosition()).isEqualTo(new Position(3));
    }

}
