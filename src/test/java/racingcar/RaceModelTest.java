package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceModelTest {
    @Test
    void testRace() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(new CarName("pobi")));
        carList.add(new Car(new CarName("crong")));
        Cars cars = new Cars(carList);
        Counter counter = new Counter(2);
        FakeRandomNumberGenerator fakeRandomNumberGenerator = new FakeRandomNumberGenerator(new int[]{4, 4, 4, 3});
        RaceModel raceModel = new RaceModel(cars, counter, fakeRandomNumberGenerator);

        Cars result1 = raceModel.nextRace().getFarthestTraveledCars();
        assertThat(result1.count()).isEqualTo(2);

        Cars result2 = raceModel.nextRace().getFarthestTraveledCars();
        assertThat(result2.count()).isEqualTo(1);

        Cars winners = raceModel.getWinners();
        assertThat(winners.count()).isEqualTo(1);
        Car winner = winners.get(0);
        assertThat(winner.getName().toString()).isEqualTo("pobi");
    }
}
