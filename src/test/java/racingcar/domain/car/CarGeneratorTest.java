package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CarGeneratorTest {

    @Test
    void 레이싱카_생성_테스트() {
        Cars cars = new Cars(CarGenerator.registerCars("Jin,Kim"));
        assertArrayEquals(toNameArray(cars.getCars()).toArray(),
                new String[]{"Jin","Kim"});
    }

    private List<String> toNameArray(List<Car> cars) {
        List<String> nameArray = new ArrayList<>();
        for (Car car : cars) {
            nameArray.add(car.getCarName().getName());
        }
        return nameArray;
    }
}