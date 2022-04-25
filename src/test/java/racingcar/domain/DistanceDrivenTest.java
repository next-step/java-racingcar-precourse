package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceDrivenTest {

    @Test
    public void 주행거리_더하기() throws Exception {
        // given
        DistanceDriven distance1 = new DistanceDriven(0);
        // when
        distance1.addDistanceDriven(2);
        // then
        assertThat(distance1.getDistanceDriven()).isEqualTo(2);
    }

    @Test
    public void 주행거리는_0_이상() throws Exception {

        // when
        // then
        DistanceDriven distance1 = new DistanceDriven(0);

        assertThatThrownBy(() -> {
            DistanceDriven distance2 = new DistanceDriven(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> {
            DistanceDriven distance3 = new DistanceDriven(0);
            distance3.addDistanceDriven(-3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }



}