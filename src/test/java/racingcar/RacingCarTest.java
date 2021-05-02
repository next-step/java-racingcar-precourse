package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("난수 3이 입력되었을 경우 자동차는 이동하지 않는다.")
    void stop() {
        // given
        RacingCar racingCar = new RacingCar(new Name("tester"));
        TravelDistance zero = TravelDistance.zero();

        int random = 3;

        // when
        racingCar.moveForward(random);
        TravelDistance travelDistance = racingCar.getForwardDistance();

        // then
        assertThat(travelDistance).isEqualTo(zero);
    }

}
