package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    String[] racingCarName;
    RacingCars racingCars;

    @BeforeEach
    public void create() {
        racingCarName = new String[]{"자동차1","자동차2","자동차3"};
        racingCars = new RacingCars(racingCarName);
    }

    @Test
    void 자동차_세팅() {
        for (int index = 0; index < racingCarName.length; index++) {
            assertThat(racingCarName[index]).isEqualTo(racingCars.getNameByIndex(index + 1));
        }
    }
}
