package model;

import dto.CarResponse;
import dto.RaceResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @DisplayName("이동 판단 값 리스트를 넘기면 이동시킨 결과 RaceResult 를 반환")
    @Test
    void testRace() {
        Car moveCar1 = new Car("aaa");
        Car moveCar2 = new Car("bbb");
        Car stopCar = new Car("ccc");

        List<Car> cars = Arrays.asList(moveCar1, moveCar2, stopCar);
        RacingCars racingCars = new RacingCars(cars);

        // when
        List<Integer> numbers = Arrays.asList(4, 5, 2);
        RaceResult result = racingCars.race(numbers);
        List<CarResponse> carResponses = result.getResponses();

        // then
        assertThat(carResponses.get(0).getCarName()).isEqualTo("aaa");
        assertThat(carResponses.get(0).getPosition()).isEqualTo(1);

        assertThat(carResponses.get(1).getCarName()).isEqualTo("bbb");
        assertThat(carResponses.get(1).getPosition()).isEqualTo(1);

        assertThat(carResponses.get(2).getCarName()).isEqualTo("ccc");
        assertThat(carResponses.get(2).getPosition()).isEqualTo(0);
    }

    @DisplayName("RacingCars 의 승자 구하기")
    @Test
    void testGetWinners() {
        Car car1 = new Car("aaa");
        Car car2 = new Car("bbb");
        Car car3 = new Car("ccc");

        List<Car> cars = Arrays.asList(car1, car2, car3);
        RacingCars racingCars = new RacingCars(cars);

        List<Integer> numbers = Arrays.asList(4, 5, 2);
        racingCars.race(numbers);

        Winners winners = racingCars.getWinners();
        String[] split = winners.getWinnerNames().split(",");

        assertThat(split).containsExactly("aaa", "bbb");
    }
}
