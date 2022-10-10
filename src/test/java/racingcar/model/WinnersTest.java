package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMove;
import racingcar.strategy.RandomMove;

class WinnersTest {

    private List<Car> cars;

    @BeforeEach
    void init() {
        this.cars = new ArrayList<>();

        initCars();

        for (Car car : cars) {
            car.move();
        }
    }

    private void initCars() {
        Car car1 = new Car("test1", new RandomMove());
        Car car2 = new Car("test2", new AlwaysMove());
        Car car3 = new Car("test3", new RandomMove());
        Car car4 = new Car("test4", new RandomMove());

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @Test
    void 일등_이름_가져오기() {
        Winners winners = Winners.of(this.cars);
        assertThat(winners.getWinnersName()).contains("test2");
    }
}