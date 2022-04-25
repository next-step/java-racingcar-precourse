package racingcar.validator.count;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorCountTest {

    @Test
    @DisplayName("ValidatorCount가 0 이하의 값이 들어왔을 때 에러를 발생시키는지 확인한다.")
    void 비정상_INPUT_검증_0() {
        assertThatThrownBy(
                () -> {
                    consoleInput(new String[]{"-1"});

                    ValidatorCount validatorCount = new ValidatorCount();
                    validatorCount.validateCnt();
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행할 횟수를 0 이상 입력해주세요.");
    }

    @Test
    @DisplayName("ValidatorCount가 정수가 아닌 값이 들어왔을 때 에러를 발생시키는지 확인한다.")
    void 비정상_INPUT_검증_String() {
        assertThatThrownBy(
                () -> {
                    consoleInput(new String[]{"e"});

                    ValidatorCount validatorCount = new ValidatorCount();
                    validatorCount.validateCnt();
                }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘못된 값을 입력하셨습니다.(정수 입력)");
    }

    @Test
    @DisplayName("ValidatorCount가 String으로 들어온 정수 값을 정상적으로 반환하는지 확인한다.")
    void 정상_INPUT_검증() {
        consoleInput(new String[]{"3"});

        ValidatorCount validatorCount = new ValidatorCount();
        int result = validatorCount.validateCnt();

        assertEquals(3, result, "숫자 3을 반환해야 합니다.");
    }

    public void consoleInput(String[] args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}