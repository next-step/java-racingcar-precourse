import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarRacingTest {

    private int num;
    private String cars;

    @BeforeEach
    void setUp() {
        num = 5;
        cars = "SM5, pobi, honux, niro";

    }

    @Test
    void racingCars() {
        String[] carArr = cars.split(",");
        List<String> carList = Arrays.stream(carArr).map(s -> s.trim()).collect(Collectors.toList());

        assertThat(carList.size()).isEqualTo(carArr.length);
    }

    @Test
    void randomNumber() {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int randNum = random.nextInt(10);
            assertThat(randNum).isLessThan(10);
        }
    }

    @Test
    void ge4GoOrLe3Stop() {
        List<Cars> carList = CarRacing.getCars(cars, ",");

        Random random = new Random();
        while (num -- > 0) {
            for (Cars car : carList) {
                int randNum = random.nextInt(10);
                if (randNum >= 4) {
                    car.setPosition(car.getPosition() + "-");
                }
            }
        }
    }
}
