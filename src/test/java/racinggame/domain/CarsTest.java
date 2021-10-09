package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private final String NAMES = "abc,dg,ef";

    @Test
    void 생성() {

        Cars cars = new Cars(NAMES);
        List<Car> carList = mapNameTextToCarList();

        assertEquals(new Cars(NAMES), new Cars(NAMES));
        assertEquals(new Cars(cars), new Cars(NAMES));
        assertEquals(new Cars(carList), new Cars(NAMES));
    }

    private List<Car> mapNameTextToCarList() {
        String[] names = NAMES.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    @Test
    void 한칸_전진하는가() {
        Cars cars = new Cars(NAMES);
        cars.move(() -> true);
        for (Car car : cars.elements()) {
            assertEquals(car.getDistance(), Distance.of(1));
        }
    }

    @Test
    void 우승자_확인() {
        Cars cars = new Cars(NAMES);
        cars.move(() -> true);
        assertEquals(new Cars(NAMES), new Cars(cars.winners()));
    }

    @Test
    void elements() {
        Cars cars = new Cars(NAMES);
        List<Car> carList = Arrays.asList(new Car("abc"), new Car("dg"), new Car("ef"));
        assertEquals(cars.elements(), carList);
    }
}