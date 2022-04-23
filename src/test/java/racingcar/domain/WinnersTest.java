package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @DisplayName("우승자가 한명이라면 true 로 리턴해야 한다")
    @Test
    void winners_test() {
        Car car = mock(Car.class);
        List<Car> cars = Arrays.asList(car);
        Winners winners = new Winners(cars);

        assertThat(winners.isSoleWinners());
    }

    @DisplayName("우승자가 한명 이상이라면 false 로 리턴해야 한다")
    @Test
    void winners_test_v2() {
        Car car = mock(Car.class);
        Car car_2 = mock(Car.class);
        List<Car> cars = Arrays.asList(car, car_2);
        Winners winners = new Winners(cars);

        assertFalse(winners.isSoleWinners());
    }
}
