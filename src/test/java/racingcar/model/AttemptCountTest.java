package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AttemptCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"오", "5.5", "-1", "0"})
    @DisplayName("이동할 횟수 입력값은 0이상의 정수가 아니면 예외가 발생한다.")
    void constructor_이동할_횟수_입력값은_0이상의_정수가_아니면_예외(String count) {
        Assertions.assertThatThrownBy(() -> new AttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "10", "01"})
    @DisplayName("이동할 횟수 입력값은 0이상의 정수라면 정상 생성된다.")
    void constructor_이동할_횟수_입력값은_0이상의_정수라면_정상(String count) {
        // when
        AttemptCount attemptCount = new AttemptCount(count);
        // then
        Assertions.assertThat(attemptCount.getCount()).isEqualTo(Integer.parseInt(count));
    }

}