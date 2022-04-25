package racingcar.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarGenerator;
import racingcar.domain.car.Cars;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.Referee;
import racingcar.domain.racing.Turn;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintTurnOverResultTest {
    private Cars cars;
    private Racing racing;

    @BeforeEach
    void setCars() {
        cars = new Cars(CarGenerator.registerCars("Jin,Park"));
        racing = new Racing(cars, new Referee(cars), new Turn(1));
    }

    @Test
    void printPositionBar() {
        int position = 4;
        assertThat(racing.getPositionBar(position)).isEqualTo("----");
    }
}
