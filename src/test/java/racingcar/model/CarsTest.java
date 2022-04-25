package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    public void constructor() {
        //given
        String[] names = new String[]{"최용락", "용", "락", "용락"};

        //when
        Cars cars = new Cars(names);

        //then
        assertEquals(4, cars.size());
    }

    @Test
    public void getWinnersNames() {
        //given
        Cars cars = createTestCars();

        //when
        List<String> winnersNames = cars.getWinnersNames();

        //then
        assertThat(winnersNames).containsExactly("최용락", "용락");
    }

    private Cars createTestCars() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("최용락");
        car1.move(() -> true);
        carList.add(car1);
        Car car2 = new Car("용락");
        car2.move(() -> true);
        carList.add(car2);
        Car car3 = new Car("락");
        carList.add(car3);
        Cars cars = new Cars(carList);
        return cars;
    }

}