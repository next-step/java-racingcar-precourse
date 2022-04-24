package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private  Cars cars;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("car11",0);
        Car car2 = new Car("car22",0);
        Car car3 = new Car("car333333",0);
        List<Car> list = new ArrayList<Car>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        cars = new Cars(list);
    }

    @Test
    void move() {
    }

}
