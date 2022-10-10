package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class MessageUtilsTest {
    private static final int testRepeat = 2;

    @Test
    @DisplayName("포지션이 특정 문자로 할당되지는 확인")
    void raplace_position_to_special_character_test() {
        // Given
        String carName;
        String specialCharacter;

        // when
        carName = "phobi";
        specialCharacter = "-";
        RacingCar racingCar = new RacingCar(carName);
        for (int i = 0; i < testRepeat; i++) {
            racingCar.moveForward();
        }

        // Then
        assertThat(MessageUtils.replcaePositionToSpecialCharacter(racingCar, specialCharacter)).isEqualTo("--");
    }
}