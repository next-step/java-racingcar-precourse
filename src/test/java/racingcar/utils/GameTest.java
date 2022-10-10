package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entities.Car;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;

    @BeforeEach
    void initTest() {
        car1 = new Car(1, "BOMI");
        car2 = new Car(3, "SUBINI");
        car3 = new Car(2, "DARAMI");
        car4 = new Car(3, "SUJINI");
    }

    @DisplayName("우승자동차들을 결정하는 기능")
    @Test
    void pickWinnerCarsTest() {

        Game game = new Game();
        assertThat(game.pickWinnerCars(Arrays.asList(car1, car2, car3, car4)).equals(Arrays.asList(car2, car4))).isTrue();

    }

}
