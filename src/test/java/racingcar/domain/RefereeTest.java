package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    Cars cars;
    Car leeCar = new Car(new CarName("lee"));
    Car kimCar = new Car(new CarName("kim"));
    Car parkCar = new Car(new CarName("park"));
    Car jungCar = new Car(new CarName("jung"));

    @BeforeEach
    void setUp(){
        cars = new Cars(Arrays.asList(leeCar,kimCar,parkCar,jungCar));
    }

    @Test
    @DisplayName("우승자가 한명일 경우")
    void oneWinner(){
        leeCar.move(5);
        kimCar.move(3);
        parkCar.move(3);
        jungCar.move(3);

        Referee referee = new Referee(cars);
        Cars winners = referee.getWinners();

        assertThat(winners.getSize()).isEqualTo(1);
        assertThat(winners.getCarNames()).isEqualTo("lee");
    }

    @Test
    @DisplayName("우승자가 두명 이상일 경우")
    void moreTwoWinner(){
        leeCar.move(5);
        kimCar.move(3);
        parkCar.move(5);
        jungCar.move(5);

        Referee referee = new Referee(cars);
        Cars winners = referee.getWinners();

        assertThat(winners.getSize()).isEqualTo(3);
        assertThat(winners.getCarNames()).isEqualTo("lee,park,jung");
    }


}
