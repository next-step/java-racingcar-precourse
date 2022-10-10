package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;

class RaceServiceTest {

    RaceService service;
    Cars cars;

    @BeforeEach
    void setUp() {
        service = new RaceService();

        cars = new Cars(Arrays.asList("john", "mike", "kim", "yb"));
        cars.getValue().get(0).getPosition().setPosition(3);
        cars.getValue().get(1).getPosition().setPosition(3);
        cars.getValue().get(2).getPosition().setPosition(2);
        cars.getValue().get(3).getPosition().setPosition(1);
    }

    @Test
    void createCars() {
        Cars cars = service.returnCars("John,Mike,Krist");
        assertAll(
                () -> assertThat(cars.getValue()).hasSize(3),
                () -> cars.getValue().forEach(one -> assertThat("John,Mike,Krist").contains(one.getName().getValue()))
        );
    }

    @Test
    void detectWinner() {
        Cars winners = service.detectWinner(cars);
        assertAll(
                () -> assertThat(winners.getValue()).hasSize(2),
                () -> assertThat(winners.getValue().get(0).getNameInString()).contains("john"),
                () -> assertThat(winners.getValue().get(1).getNameInString()).contains("mike")
        );

    }

    @Test
    void addCoWinner() {
        Cars winners = new Cars(new ArrayList<>(Collections.singletonList("john")));
        winners.getValue().get(0).getPosition().setPosition(3);
        int MAX = winners.getValue().get(0).getPositionInteger();
        Name name = new Name("mike");
        Car car = new Car(name);
        car.getPosition().setPosition(3);
        service.addCoWinner(MAX, winners, car);
        assertThat(winners.getValue().size()).isEqualTo(2);
    }

    @Test
    void getMax() {
        Cars winners = new Cars(new ArrayList<>());
        int MAX = 0;
        Name name = new Name("mike");
        Car car = new Car(name);
        car.getPosition().setPosition(3);
        int result = service.getMax(MAX, winners, car);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void makePrintableWinners() {
        String actual = service.makePrintableWinners(cars);
        assertAll(
                () -> assertThat(actual).doesNotStartWith(","),
                () -> assertThat(actual).contains("john", "mike", "kim", "yb", ","),
                () -> assertThat(actual).containsWhitespaces(),
                () -> assertThat(actual).doesNotEndWith(",")
        );
    }

}