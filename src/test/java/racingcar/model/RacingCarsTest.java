package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("레이싱 자동차를 wrapping 테스트")
    public void ValidationSuccessTest() {
        // Given
        RacingCars racingCars = new RacingCars();
        racingCars.addRacingCar(new RacingCar("poni"));

        // When
        int racingCarSize = racingCars.getRacingCars().size();

        // Then
        assertThat(racingCarSize)
                .isEqualTo(1);
    }

}