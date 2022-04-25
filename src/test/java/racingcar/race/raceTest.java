package racingcar.race;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.car.Cars;

public class raceTest {
    
    @Test
    void finish_round(){        
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("TEST1"));
        carList.add(new Car("TEST2"));

        Cars cars = new Cars(carList);
        Race race = new Race(cars);

        race.finishRound();

        assertThat(race.getRound()).isEqualTo(1);
    }
}
