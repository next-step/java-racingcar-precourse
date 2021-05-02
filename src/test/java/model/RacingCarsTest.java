package model;

import dto.CarRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @DisplayName("CarRequest 하나를 넘기면 RacingCars 중에서 해당 Car 만 이동시킴")
    @Test
    void testMoveOne() {
        // given
        String carName = "aaa";
        int moveJudgementNumber = 4;
        CarRequest carRequest = new CarRequest(carName, moveJudgementNumber);

        Car car = new Car(carName);
        List<Car> cars = Collections.singletonList(car);
        RacingCars racingCars = new RacingCars(cars);

        // when
        CarResponse carResponse = racingCars.moveOne(carRequest);

        // then
        assertThat(carResponse.getPosition()).isEqualTo(1);
    }

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
