package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    @Test
    void 자동차_이름_추가() throws NoSuchFieldException, IllegalAccessException {
        Cars cars = new Cars(new String[]{"pobi","honux","crong"});
        Field field = cars.getClass().getDeclaredField("cars");
        field.setAccessible(true);
        List<Car> list = (List<Car>) field.get(cars);
        assertEquals(3, list.size());
    }
}
