package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.CarMoveRule;

public class CurrentResultTest {
    CarMoveRule carMoveRule;

    @BeforeEach
    public void set() {
        carMoveRule = new CarMoveRule(1, 0, 4, "-");
    }


    @DisplayName("현재 결과를 조회했을 때, 기대값과 일치해야 한다.")
    @Test
    public void getCurrentResultSuccess_P01() {
        String expected = "hi : ---\nhello : ---\n";
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("hi", 3, carMoveRule));
        cars.add(new RacingCar("hello", 3, carMoveRule));

        CurrentResult currentResult = new CurrentResult(cars);
        assertThat(currentResult.getResult()).isEqualTo(expected);
    }
}
