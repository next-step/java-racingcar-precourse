package racingcar.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RefereeTest {

    @Test
    void 단일_우승자() throws Exception {
        // given
        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);

        Car hamaCar = new Car("hame");
        positionField.set(hamaCar, 5);
        Car pobiCar = new Car("pobi");
        positionField.set(pobiCar, 3);
        Car honuxCar = new Car("honux");
        positionField.set(honuxCar, 1);

        List<Car> cars = new ArrayList<>();
        cars.add(hamaCar);
        cars.add(pobiCar);
        cars.add(honuxCar);

        // when
        String winner = Referee.judgeWinners(cars);

        // then
        assertEquals(hamaCar.getName(), winner);
    }

    @Test
    void 공동_우승자() throws Exception {
        // given
        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);

        Car hamaCar = new Car("hame");
        positionField.set(hamaCar, 5);
        Car pobiCar = new Car("pobi");
        positionField.set(pobiCar, 5);
        Car honuxCar = new Car("honux");
        positionField.set(honuxCar, 1);

        List<Car> cars = new ArrayList<>();
        cars.add(hamaCar);
        cars.add(pobiCar);
        cars.add(honuxCar);

        // when
        String winners = Referee.judgeWinners(cars);

        // then
        assertThat(winners).contains(hamaCar.getName(), pobiCar.getName());
    }
}
