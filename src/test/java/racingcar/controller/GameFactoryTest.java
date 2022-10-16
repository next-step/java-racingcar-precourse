package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class GameFactoryTest {
    private GameFactory factory = new GameFactory();
    @Test
    public void makeCarTest(){
        String names = "a,b,c,d";
        Cars cars = factory.makeCars(names);
        assertThat(cars.size()).isEqualTo(4);
        Car carA = cars.getCar(0);
        assertThat(carA.getName()).isEqualTo(new Name("a"));
    }

    @Test
    public void makeCarTestWithException(){
        String names = "a,b,c,defrr323";
        Cars cars = factory.makeCars(names);
        assertThat(cars.size()).isEqualTo(3);

    }

}
