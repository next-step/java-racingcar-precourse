package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enumeration.CarStatus;

class ForwardCountTest {
    @DisplayName("멈춤 테스트")
    @Test
    void stop() {
        ForwardCount fc = new ForwardCount();
        fc.setCountByCarStatus(CarStatus.STOP);
        assertThat(fc.getCount()).isEqualTo(0);
    }

    @DisplayName("전진 테스트")
    @Test
    void forward() {
        ForwardCount fc = new ForwardCount();
        fc.setCountByCarStatus(CarStatus.FORWARD);
        assertThat(fc.getCount()).isEqualTo(1L);
    }
}