package racingcar.model.user;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingRepeatCountTest {

    @ParameterizedTest
    @DisplayName("레이싱을 치룰 횟수의 값이 양수인지 유효성 검사를 한다.")
    @ValueSource(ints = {-1, 0})
    public void 레이싱을_치룰_횟수값이_음수인지_예외체크(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRepeatCount(input));
    }

    @Test
    @DisplayName("시도할 횟수를 나타내는 객체가 정상적으로 생성되는지 확인한다.")
    public void 시도할_횟수_객체_생성_여부_확인() {
        int repeatCount = 3;
        RacingRepeatCount racingRepeatCount = new RacingRepeatCount(repeatCount);

        assertEquals(racingRepeatCount.getRepeatCount(), repeatCount);
    }

}
