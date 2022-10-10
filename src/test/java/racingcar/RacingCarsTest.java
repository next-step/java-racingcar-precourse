package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCarsTest {

    @DisplayName("RacingCars 우승자 찾아내기")
    @Test
    void pickWinner() {
        RacingCar racingCar1 = new RacingCar("오성록");
        RacingCar racingCar2 = new RacingCar("우승자");
        RacingCar racingCar3 = new RacingCar("루저");
        racingCar1.move(1);
        racingCar2.move(4);
        racingCar3.move(3);
        RacingCars racingCars = RacingCars.of(racingCar1, racingCar2, racingCar3);

        assertThat(racingCars.pickWinners()).isEqualTo("우승자");
    }

    @DisplayName("RacingCars 여러 우승자 찾아내기")
    @Test
    void pickWinners() {
        RacingCar racingCar1 = new RacingCar("오성록");
        RacingCar racingCar2 = new RacingCar("우승자");
        RacingCar racingCar3 = new RacingCar("루저");
        racingCar1.move(4);
        racingCar2.move(4);
        racingCar3.move(3);
        RacingCars racingCars = RacingCars.of(racingCar1, racingCar2, racingCar3);

        assertThat(racingCars.pickWinners()).isEqualTo("오성록, 우승자");
    }
}
