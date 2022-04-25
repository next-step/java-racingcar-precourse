package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        Car sona = new Car(new Name("sona"), new Position(1));
        Car x3 = new Car(new Name("x3"), new Position(2));
        Car x5 = new Car(new Name("x5"), new Position(2));
        cars = new Cars(Arrays.asList(sona, x3, x5));
    }

    @Test
    void 우승자들을_찾을_수_있다() {
        List<Car> winners = cars.findWinners();
        assertThat(winners).containsExactly(
                new Car(new Name("x3"), new Position(2)),
                new Car(new Name("x5"), new Position(2))
        );
    }
}
