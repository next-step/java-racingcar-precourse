package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 자동차_세팅() {
        String[] racingCarName = {"자동차1", "자동차2", "자동차3", "car4"};
        RacingCars racingCars = new RacingCars(racingCarName);
        for (int index = 0; index < racingCarName.length; index++) {
            assertThat(racingCarName[index]).isEqualTo(racingCars.getNameByIndex(index + 1));
        }
    }
}
