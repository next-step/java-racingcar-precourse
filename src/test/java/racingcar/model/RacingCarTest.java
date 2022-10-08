package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingGameUtil;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingCarTest {
    @DisplayName(value = "전진")
    @Test
    void 전진() {
        RacingCar racingCar = new RacingCar("자동차");
        int prevPosition = racingCar.getPosition();
        racingCar.moveOrNot(RacingGameUtil.MOVABLE_NUMBER);
        assertThat(prevPosition + 1).isEqualTo(racingCar.getPosition());
    }

    @DisplayName(value = "정지")
    @Test
    void 정지() {
        RacingCar racingCar = new RacingCar("자동차");
        int prevPosition = racingCar.getPosition();
        racingCar.moveOrNot(RacingGameUtil.MOVABLE_NUMBER - 1);
        assertThat(prevPosition).isEqualTo(racingCar.getPosition());
    }
}
