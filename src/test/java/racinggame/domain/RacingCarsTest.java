package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    @Test
    public void RacingCars는_여러개의_RacingCar를_가진다() {
        String racingCarsName = "1,2,3,4,5";
        RacingCars racingCars = new RacingCars(racingCarsName);
        Assertions.assertThat(racingCars.getRacingCars().isEmpty()).isFalse();
    }
}
