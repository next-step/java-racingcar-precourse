package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceLogTest {

    @Test
    @DisplayName("getMileage()는 총 주행거리를 반환한다.")
    void 주행거리_계산() {
        final DistanceLog distanceLog = new DistanceLog();
        distanceLog.record(4);
        distanceLog.record(4);
        distanceLog.record(3);
        assertThat(distanceLog.calcMileageAsSymbol()).isEqualTo("--");
    }
}