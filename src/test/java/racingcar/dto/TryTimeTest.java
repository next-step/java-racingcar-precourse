package racingcar.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryTimeTest {

    @Test
    void TryTime_객체_생성() {
        TryTime tryTime = new TryTime("2");
        assertThat(tryTime.getValue()).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 시도할_회수가_null_or_empty_인경우_에러(String input) {
        assertThatThrownBy(() -> new TryTime(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 회수가 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "아"})
    void 시도할_회수가_숫자가_아닌경우_에러(String input) {
        assertThatThrownBy(() -> new TryTime(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 시도할_회수가_0이하인_경우_에러(String input) {
        assertThatThrownBy(() -> new TryTime(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도할 회수는 1이상이어야 합니다.");
    }

}
