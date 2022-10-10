package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingCarPositionTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    public void validateCarMoveForwardTest() {
        RacingCarPosition racingCarPosition = new RacingCarPosition(0);
        racingCarPosition.moveForward();
        assertThat(racingCarPosition).isEqualTo(new RacingCarPosition(1));
    }

    @DisplayName("자동차 위치 음수 값 오류")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    public void throwExceptionWhenCarPositionNegative(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCarPosition(input);
        });
    }


}
