package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void getWinners() {
        Winners winners = new Winners(getCars());

        List<Car> winnerCars = winners.getWinners();

        assertThat(winnerCars.size()).isEqualTo(1);
        assertThat(winnerCars.get(0).getName()).isEqualTo("pobi");
    }

    private List<Car> getCars() {
        return Arrays.asList(
                new Car("pobi", 1),
                new Car("woni", 0)
        );
    }
}
