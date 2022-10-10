package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    void AddCar() {
        Cars actual = new Cars();
        Car newCar = new Car("newc");
        actual.add(newCar);
        Cars expected = new Cars(Arrays.asList(newCar));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldYieldWinner() {
        Car loser = new Car("a", new Spot(1));
        Car winner = new Car("b", new Spot(2));
        Cars cars = new Cars(Arrays.asList(loser, winner));
        Cars actual = cars.yieldFinalResult().winners();
        Cars expected = new Cars(Arrays.asList(winner));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldYieldTwoWinnersWithIdenticalSpot() {
        Car loser = new Car("a", new Spot(1));
        Car winner1 = new Car("b", new Spot(2));
        Car winner2 = new Car("c", new Spot(2));
        Cars cars = new Cars(Arrays.asList(loser, winner1, winner2));
        Cars actual = cars.yieldFinalResult().winners();
        Cars expected = new Cars(Arrays.asList(winner1, winner2));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ShouldConcatNamesWithComma() {
        Cars cars = new Cars(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));
        String actual = cars.names();
        String expected = "a,b,c";
        assertThat(actual).isEqualTo(expected);

    }
}
