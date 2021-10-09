package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("우승자_검증_1")
    void 우승자_검증_1() {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("test1", 0));
        cars.add(new Car("test2", 3));
        cars.add(new Car("test3", 4));

        assertThat(Racing.getWinner(cars)).isEqualTo("test3");
    }

    @Test
    @DisplayName("우승자_검증_2")
    void 우승자_검증_2() {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("test1", 0));
        cars.add(new Car("test2", 3));
        cars.add(new Car("test3", 3));

        assertThat(Racing.getWinner(cars)).isEqualTo("test2,test3");
    }


}
