package racingcar.game;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RaceJudgmentTest {

    @DisplayName("이동거리가 1인 레이싱카(test1), 이동거리가 3인 레이싱카(test2), 이동거리가 2인 레이싱카(test3) 의 결과를 판단하면"
            + "이동거리가 3인 레이싱카(test2) 가 winner 가 되어야 한다")
    @Test
    void winner_test() {
        Car car_1 = mock(Car.class);
        when(car_1.getName())
                .thenReturn("test1");
        when(car_1.getDistanceCount())
                .thenReturn(1);
        when(car_1.getDistanceByDash())
                .thenReturn("-");

        Car car_2 = mock(Car.class);
        when(car_2.getName())
                .thenReturn("test2");
        when(car_2.getDistanceCount())
                .thenReturn(3);
        when(car_2.getDistanceByDash())
                .thenReturn("---");

        Car car_3 = mock(Car.class);
        when(car_3.getName())
                .thenReturn("test3");
        when(car_3.getDistanceCount())
                .thenReturn(2);
        when(car_3.getDistanceByDash())
                .thenReturn("--");

        List<Car> carList = Arrays.asList(car_1, car_2, car_3);

        Cars cars = mock(Cars.class);
        when(cars.getCars())
                .thenReturn(carList);

        RaceJudgment raceJudgment = new RaceJudgment(cars);
        Winners winners = raceJudgment.getWinners();
        Car 우승_자동차 = winners.getWinners().get(0);

        assertTrue(우승_자동차.equals(car_2));
    }

    @DisplayName("이동거리가 1인 레이싱카(test1), 이동거리가 3인 레이싱카(test2), 이동거리가 3인 레이싱카(test3) 의 결과를 판단하면"
            + "이동거리가 3인 레이싱카(test2,test3) 두개의 레이싱카가 winner 가 되어야 한다")
    @Test
    void winner_test_v2() {
        Car car_1 = mock(Car.class);
        when(car_1.getName())
                .thenReturn("test1");
        when(car_1.getDistanceCount())
                .thenReturn(1);
        when(car_1.getDistanceByDash())
                .thenReturn("-");

        Car car_2 = mock(Car.class);
        when(car_2.getName())
                .thenReturn("test2");
        when(car_2.getDistanceCount())
                .thenReturn(3);
        when(car_2.getDistanceByDash())
                .thenReturn("---");

        Car car_3 = mock(Car.class);
        when(car_3.getName())
                .thenReturn("test3");
        when(car_3.getDistanceCount())
                .thenReturn(3);
        when(car_3.getDistanceByDash())
                .thenReturn("---");

        List<Car> carList = Arrays.asList(car_1, car_2, car_3);

        Cars cars = mock(Cars.class);
        when(cars.getCars())
                .thenReturn(carList);

        RaceJudgment raceJudgment = new RaceJudgment(cars);
        Winners winners = raceJudgment.getWinners();
        List<Car> 우승_자동차_목록 = winners.getWinners();

        assertTrue(우승_자동차_목록.contains(car_2));
        assertTrue(우승_자동차_목록.contains(car_3));
    }

    @DisplayName("이동거리가 모두 0이면 모두 공동 우승자가 된다")
    @Test
    void winner_test_v3() {
        Car car_1 = mock(Car.class);
        when(car_1.getName())
                .thenReturn("test1");
        when(car_1.getDistanceCount())
                .thenReturn(0);
        when(car_1.getDistanceByDash())
                .thenReturn("");

        Car car_2 = mock(Car.class);
        when(car_2.getName())
                .thenReturn("test2");
        when(car_2.getDistanceCount())
                .thenReturn(0);
        when(car_2.getDistanceByDash())
                .thenReturn("");

        Car car_3 = mock(Car.class);
        when(car_3.getName())
                .thenReturn("test3");
        when(car_3.getDistanceCount())
                .thenReturn(0);
        when(car_3.getDistanceByDash())
                .thenReturn("");

        List<Car> carList = Arrays.asList(car_1, car_2, car_3);

        Cars cars = mock(Cars.class);
        when(cars.getCars())
                .thenReturn(carList);

        RaceJudgment raceJudgment = new RaceJudgment(cars);
        Winners winners = raceJudgment.getWinners();
        List<Car> 우승_자동차_목록 = winners.getWinners();

        assertTrue(우승_자동차_목록.contains(car_1));
        assertTrue(우승_자동차_목록.contains(car_2));
        assertTrue(우승_자동차_목록.contains(car_3));
    }
}
