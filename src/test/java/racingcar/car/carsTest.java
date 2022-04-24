package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class carsTest {
    @Test
    void get_moves(){
        List<Car> carList = new ArrayList<Car>(){};
        Car car1 = new Car("TEST1");
        Car car2 = new Car("TEST2");
        carList.add(car1);
        carList.add(car2);

        Cars cars = new Cars(carList);
        cars.inputScores();

        Map<String, Integer> moves = cars.getCarMoves();
        
        assertThat(moves.containsKey("TEST1")).isTrue();
        assertThat(moves.containsKey("TEST2")).isTrue();
    }
}
