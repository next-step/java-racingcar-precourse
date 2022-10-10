package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsInRaceTest {

    @Test
    void enterCarsNameInRaceTest() {
        CarsInRace cars = new CarsInRace("abcdef,abcdef");

    }

    @Test
    void winnerString() {
        CarsInRace carsInRace = new CarsInRace("a,b,c");

        assertThat(carsInRace.winnerString()).contains("a,b,c");
    }
}
