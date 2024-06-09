package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RaceTest {

    @Test
    void getCars() {
        String[] carNames = {"pobi", "woni", "jun"};
        Race race = new Race(carNames);
        List<Car> cars = race.getCars();

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void race() {
        String[] carNames = {"pobi", "woni", "jun"};
        Race race = new Race(carNames);
        race.race();

        List<Car> cars = race.getCars();
        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void getWinners() {
        String[] carNames = {"pobi", "woni", "jun"};
        Race race = new Race(carNames);
        race.race();

        List<String> winners = race.getWinners();
        assertThat(winners).isNotEmpty();
    }
}