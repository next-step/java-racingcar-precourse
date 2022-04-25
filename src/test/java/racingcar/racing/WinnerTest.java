package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @Test
    @DisplayName("우승자 생성 실패 테스트")
    void init_exception() {
        // given

        // when & then
        assertThatThrownBy(() -> new Winner(null))
                .isInstanceOf(IllegalArgumentException.class);

    }
}