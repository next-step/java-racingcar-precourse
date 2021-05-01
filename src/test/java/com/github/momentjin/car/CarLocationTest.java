package com.github.momentjin.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarLocationTest {

    @DisplayName("increaseOne을 호출하면, 1 증가된 Location을 반환한다")
    @Test
    public void increaseOne() {

        // given
        CarLocation originCarLocation = CarLocation.ZERO;

        // when
        CarLocation increasedCarLocation = originCarLocation.increaseOne();

        // then
        CarLocation expectedCarLocation = new CarLocation(1);
        assertThat(increasedCarLocation).isEqualTo(expectedCarLocation);
    }
}
