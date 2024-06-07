package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -10})
    void 시도횟수가_1_미만이면_예외발생(int round) {
        //when, then
        assertThatThrownBy(() -> new Round(round))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 시도 횟수는 최소 1 이상이어야 합니다.");
    }
}
