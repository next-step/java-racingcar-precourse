package com.game.racingCar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.game.global.config.RacingCarConfig.GO_FORWARD_STANDARD;
import static com.game.global.config.RacingCarConfig.RACING_START_LINE;

class RacingCarTest {

    private final String CAR_NAME = "jun";


    @DisplayName("이동 테스트")
    @Test
    public void goForwardTest() {
        // Given
        final RacingCar racingCar = new RacingCar(CAR_NAME);

        // When
        racingCar.goForward(GO_FORWARD_STANDARD);

        // Then
        Assertions.assertEquals(RACING_START_LINE + 1, racingCar.getLocation());
    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        // Given
        final RacingCar racingCar = new RacingCar(CAR_NAME);

        // When
        racingCar.goForward(GO_FORWARD_STANDARD - 1);

        // Then
        Assertions.assertEquals(RACING_START_LINE, racingCar.getLocation());
    }

}
