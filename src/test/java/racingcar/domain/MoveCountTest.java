package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoveCountTest {

    @Test
    @DisplayName("사용자 횟수 입력 문자열을 숫자로 변경")
    void constructor() {
        assertThat(new MoveCount("1").getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자 횟수 입력 문자열을 숫자로 변경")
    void constructor_error() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new MoveCount(null));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new MoveCount(""));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new MoveCount("0"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new MoveCount("a"));
    }

}