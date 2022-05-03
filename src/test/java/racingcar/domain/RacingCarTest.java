package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    final private RacingCar car = new RacingCar("기본테스트");

    @Test
    @DisplayName(value="레이싱 카 이동 테스트")
    public void moveRacingCarTest(){
        int prevPosition = car.getRacingCarPosition();
        car.moveCarOrNot(4);
        assertThat(car.getRacingCarPosition()).isEqualTo(prevPosition+1);
    }

}
