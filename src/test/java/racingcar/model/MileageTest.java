package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MileageTest {
    @Test
    @DisplayName("자동차_주행거리_계산")
    void 자동차_주행거리_계산() {
        Mileage mileage = new Mileage();
        mileage.addMileage();
        assertThat(mileage.mileage()).isGreaterThan(0).isEqualTo(1);
    }
}
