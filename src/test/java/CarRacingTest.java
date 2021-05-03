import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarRacingTest {

    private int num;
    private String cars;
    List<Cars> carList;

    @BeforeEach
    void setUp() {
        num = 5;
        cars = "SM5, pobi, honux, niro";
        carList = CarRacing.getCars(cars, ",");
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
        CarRacing.racing(carList, num);
    }

    @Test
    void winnerCars() {
        List<Cars> finishRacing = CarRacing.racing(carList, num);
        String result = CarRacing.finish(finishRacing);
        System.out.println(result + "가 최종 우승했습니다.");
   }
}
