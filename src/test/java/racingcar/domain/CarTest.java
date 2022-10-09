package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("carName 검증")
    void carNameTest(){
        int maxScore = 4;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("car1"),new Position(1)));
        cars.add(new Car(new CarName("car2"),new Position(2)));
        cars.add(new Car(new CarName("car3"),new Position(3)));

        Assertions.assertThat(cars.get(0).getCarName().getName()).isEqualTo("car1");
        Assertions.assertThat(cars.get(1).getCarName().getName()).isEqualTo("car2");
        Assertions.assertThat(cars.get(2).getCarName().getName()).isEqualTo("car3");

    }

    @Test
    @DisplayName("carName 검증")
    void carPositionTest(){
        int maxScore = 4;
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("car1"),new Position(1)));
        cars.add(new Car(new CarName("car2"),new Position(2)));
        cars.add(new Car(new CarName("car3"),new Position(3)));

        Assertions.assertThat(cars.get(0).getPosition().getPosition()).isEqualTo(1);
        Assertions.assertThat(cars.get(1).getPosition().getPosition()).isEqualTo(2);
        Assertions.assertThat(cars.get(2).getPosition().getPosition()).isEqualTo(3);

    }

}