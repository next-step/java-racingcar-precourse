package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MovementUtilsTest {

    @Test
    void 이동횟수_입력_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> MovementUtils.validateOnlyNumber("가")
        );
    }

    @Test
    void 이동횟수_입력_정상_테스트(){
        assertThat(MovementUtils.validateOnlyNumber("123")).isEqualTo(123);
    }
}
