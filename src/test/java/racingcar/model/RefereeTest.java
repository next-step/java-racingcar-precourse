package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.ui.CarStatus;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private static Racing racing;
    private static Cars cars;

    @BeforeAll
    static void initAll() {
        racing = new Racing();
        cars = new Cars();

        cars.add(new Car("one"));
        cars.add(new Car("two"));
        cars.add(new Car("three"));

    }

    @Test
    void 우승자_한명이상_출력() {
        Referee referee = new Referee();

        cars.get(0).setStatus(CarStatus.MOVE);
        cars.get(1).setStatus(CarStatus.STOP);
        cars.get(2).setStatus(CarStatus.MOVE);
        for (Car car : cars.getCars()) {
            racing.move(car);
        }
        assertThat(referee.getWinner(cars)).contains(cars.get(0).getName(), cars.get(2).getName());
        assertThat(referee.getWinner(cars)).doesNotContain(cars.get(1).getName());
    }

    @Test
    void 우승자_한명_출력() {
        Referee referee = new Referee();

        cars.get(0).setStatus(CarStatus.MOVE);
        cars.get(1).setStatus(CarStatus.STOP);
        cars.get(2).setStatus(CarStatus.STOP);
        for (Car car : cars.getCars()) {
            racing.move(car);
        }
        assertThat(referee.getWinner(cars)).contains(cars.get(0).getName());
        assertThat(referee.getWinner(cars)).doesNotContain(cars.get(1).getName(), cars.get(2).getName());
    }
}