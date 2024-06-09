package controller;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarControllerTest {

    private RacingCarController racingCarController;

    @BeforeEach
    void setUp() {
        this.racingCarController = new RacingCarController();
    }

    @Test
    void race() {
        // given
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        // when
        List<Car> result = racingCarController.race(cars, 5);
        // then
        assertEquals(3, result.size());
    }

    @Test
    void 우승자_구하기_1명() {
        // given
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        cars.get(0).moveForward();
        cars.get(2).moveForward();
        cars.get(2).moveForward();

        // when
        List<String> winners = racingCarController.getWinner(cars);

        // then
        assertEquals(1, winners.size());
        assertEquals("car3", winners.get(0)); // car3이 1등이므로 리스트에 car3가 포함되어야 함
    }

    @Test
    void 우승자_구하기_여러명() {
        // given
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        cars.get(0).moveForward();
        cars.get(1).moveForward();
        cars.get(2).moveForward();

        // when
        List<String> winners = racingCarController.getWinner(cars);

        // then
        assertEquals(3, winners.size());
        assertEquals("car1", winners.get(0));
        assertEquals("car2", winners.get(1));
        assertEquals("car3", winners.get(2));
    }
}