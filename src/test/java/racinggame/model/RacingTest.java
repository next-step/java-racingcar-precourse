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

        Cars car = new Cars(cars);
        assertThat(Racing.getWinner(car)).isEqualTo("test3");
    }

    @Test
    @DisplayName("우승자_검증_2")
    void 우승자_검증_2() {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("test1", 0));
        cars.add(new Car("test2", 3));
        cars.add(new Car("test3", 3));

        Cars car = new Cars(cars);
        assertThat(Racing.getWinner(car)).isEqualTo("test2,test3");
    }

    @Test
    @DisplayName("자동차이름_쉼표구분_검증")
    void 자동차이름_쉼표구분_검증() {
        ArrayList<Car> carList = new ArrayList<Car>();
        carList.add(new Car("lia",0));
        carList.add(new Car("tony",0));
        carList.add(new Car("test",0));

        Cars car = new Cars(carList);
        assertThat(Cars.makeCarsByInputName("lia, tony, test")).hasSize(3);
        //assertEquals(Cars.makeCarsByInputName("lia, tony, test"), carList);
    }
}
