package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("시도횟수 입력 테스트")
public class TryCountTest {

    TryCount tryCount = new TryCount();

    @ParameterizedTest
    @ValueSource(strings = {"any", ""})
    @DisplayName("숫자가 아닌 경우 테스트")
    void tryCount_Not_Integer(String s) {
        assertThatThrownBy(() -> {
            tryCount.isInputIsInteger(s);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }



}
