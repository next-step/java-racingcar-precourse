package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    @Test
    @DisplayName("이름 설정 예외처리 확인")
    void validateRacingCarName() {
        assertThatThrownBy(() -> new RacingCar("yongwoon")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE_PREFIX);
    }

}
