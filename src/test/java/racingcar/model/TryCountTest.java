package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"abb", "^$33", "fㅎ$"})
    void 시도횟수_숫자_체크(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new TryCount(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,-4,-55"})
    void 시도횟수_최소_입력_체크(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new TryCount(inputValue);
        });
    }
}
