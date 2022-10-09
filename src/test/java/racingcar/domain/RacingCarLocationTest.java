package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarLocationTest {

    @Test
    void 레이싱_결과_멈춤이므로_location은_증가하지_않음() {
        RacingCarLocation racingCarLocation = new RacingCarLocation();
        racingCarLocation.updateLocation(RacingStatus.STOP);
        assertThat(racingCarLocation.getLocation()).isEqualTo(0);
    }

    @Test
    void 레이싱_결과_전진이므로_location은_증가함() {
        RacingCarLocation racingCarLocation = new RacingCarLocation();
        racingCarLocation.updateLocation(RacingStatus.MOVING_FORWARD);
        assertThat(racingCarLocation.getLocation()).isEqualTo(1);
    }
}