package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingStatus.MOVING_FORWARD;
import static racingcar.domain.RacingStatus.getRacingStatusValue;
import static racingcar.domain.RacingStatus.printRacingStatus;

import org.junit.jupiter.api.Test;

class RacingStatusTest {

    @Test
    void 현재_위치만큼_FORWARD_문자_반환() {
        RacingCarLocation racingCarLocation = new RacingCarLocation();
        racingCarLocation.updateLocation(MOVING_FORWARD);
        racingCarLocation.updateLocation(MOVING_FORWARD);
        assertThat(printRacingStatus(racingCarLocation).length()).isEqualTo(2);
        assertThat(printRacingStatus(racingCarLocation)).isEqualTo("--");
    }

    @Test
    void 전진이_아닐_경우_false_반환_테스트() {
        assertThat(RacingStatus.STOP.isForward()).isFalse();
    }

    @Test
    void 전진일_경우_true_반환_테스트() {
        assertThat(RacingStatus.MOVING_FORWARD.isForward()).isTrue();
    }

    @Test
    void 멈춤일_경우_반환값_테스트() {
        String result = getRacingStatusValue(RacingStatus.STOP);
        assertThat(result).isEqualTo("");
    }

    @Test
    void 전진일_경우_반환값_테스트() {
        String result = getRacingStatusValue(RacingStatus.MOVING_FORWARD);
        assertThat(result).isEqualTo("-");
    }
}