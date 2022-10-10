package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.view.Input;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void RollsWithAlwaysWinStrategy() {
        Cars cars = Input.parseCars("a,b,c");
        Race race = new Race(new AlwaysWinStrategy(), cars);
        race.rolls();
        for (Car car : cars) {
            assertThat(car).isEqualTo(new Car(car.name(), new Spot(1)));
        }
    }

    @Test
    void RollWithRandomStrategyMoveOrStay() {
        Car car = new Car("a");
        Cars cars = new Cars(Arrays.asList(car));
        Race race = new Race(new RandomStrategy(), cars);
        RollResult rollResult = race.roll(car);
        if (rollResult.isMoved) {
            assertThat(rollResult.car).isEqualTo(new Car("a", new Spot(1)));
        } else {
            assertThat(rollResult.car).isEqualTo(new Car("a", new Spot(0)));
        }
    }
}
