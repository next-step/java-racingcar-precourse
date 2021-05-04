import controller.RaceController;
import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RaceControllerTest {

    @Test
    public void parseIntTryCount() {
        String tryCount = "2";
        int values = RaceController.parseIntTryCount(tryCount);

        assertThat(values).isEqualTo(2);
    }

    public void getWinnerNames() {
        Car testCar1 = new Car("testCar1");
        Car testCar2 = new Car("testCar3");
        Car testCar3 = new Car("testCar3");
        testCar1.setIsWinner();
        testCar2.setIsWinner();

        List<Car> cars = new ArrayList<>();
        cars.add(testCar1);
        cars.add(testCar2);
        cars.add(testCar3);

        List<String> winnerNames = RaceController.getWinnerNames(cars);

        assertThat(winnerNames).hasSize(2);
    }

    @Test
    public void getWinnersLane() {
        List<String> cars = new ArrayList<>();
        cars.add("testCar1");
        cars.add("testCar2");

        System.out.println(RaceController.getWinnersLane(cars));
    }
}
