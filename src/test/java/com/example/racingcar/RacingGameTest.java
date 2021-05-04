package com.example.racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @Test
    void getDistance_ShouldBeValid() {
        Distance distance = new Distance();
        distance.go();
        distance.go();
        assertThat(distance.getDistance())
                .isEqualTo(2);
    }

    @Test
    void newName_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("aaaaaa"));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(null));
    }

    @Test
    void newName_ShouldNotThrowException() {
        assertThatCode(() -> new Name("aaa")).doesNotThrowAnyException();
    }

    @Test
    void newCar_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
    }

    @Test
    void newCar_ShouldNotThrowException() {
        assertThatCode(() -> new Car(new Name("aaa"))).doesNotThrowAnyException();
    }

    @Test
    void newCars_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Car> carList = new ArrayList<>();
            new Cars(carList);
        });
    }

    @Test
    void getMaxDistance_ShouldBeValid() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Name("aaa")));
        carList.add(new Car(new Name("bbb")));
        carList.add(new Car(new Name("ccc")));
        carList.get(0).goOrNot(true);
        carList.get(1).goOrNot(true);
        carList.get(1).goOrNot(true);
        carList.get(1).goOrNot(true);
        assertThat(new Cars(carList).getMaxDistance().getDistance())
                .isEqualTo(3);
    }

    @Test
    void findCar_ShouldBeValid() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Name("aaa")));
        carList.add(new Car(new Name("bbb")));
        carList.add(new Car(new Name("ccc")));
        carList.get(0).goOrNot(true);
        carList.get(1).goOrNot(true);
        Cars cars = new Cars(carList);
        Distance distance = new Distance();
        distance.go();
        assertThat(cars.findCar(distance).getNames()).isEqualTo("aaa,bbb");
    }
}