package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipateTest {

    @Test
    @DisplayName("자동차를 경기에 등록 시킬 수 있다.")
    void carParticipate() {
        String firstCar = "testA";
        String secondCar = "testB";

        String[] carName = {firstCar, secondCar};

        List<Car> cars = new Participate().addCar(carName);

        assertEquals(cars.size(), 2);
        assertEquals(cars.get(0).getName(), firstCar);
        assertEquals(cars.get(0).getMove(), 0);
        assertEquals(cars.get(1).getName(), secondCar);
        assertEquals(cars.get(1).getMove(), 0);
    }

}