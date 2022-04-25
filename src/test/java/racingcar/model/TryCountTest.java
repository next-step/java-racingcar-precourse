package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.exception.OverTryCountException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {
    @Test
    @DisplayName("시도기준과 시도횟수가 같은 경우 true 를 반환한다.")
    void sameBaseTryCountAndTryCount() {
        TryCount tryCount = new TryCount("3");
        tryCount.increaseCount();
        tryCount.increaseCount();
        tryCount.increaseCount();

        assertThat(tryCount.isDone()).isTrue();
    }

    @Test
    @DisplayName("시도기준보다 시도횟수가 적을 경우 false 를 반환한다.")
    void differentTryCountAndTryCount() {
        TryCount tryCount = new TryCount("3");
        tryCount.increaseCount();
        tryCount.increaseCount();

        assertThat(tryCount.isDone()).isFalse();
    }

    @Test
    @DisplayName("생성자에 숫자 문자열이 아닌 문자를 입력할 경우 예외가 발생한다.")
    void name() {
        assertThatThrownBy(() -> new TryCount("a"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("시도 기준을 초과하면 예외가 발생한다.")
    void overTryCount() {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount("3");
            tryCount.increaseCount();
            tryCount.increaseCount();
            tryCount.increaseCount();
            tryCount.increaseCount();
        }).isInstanceOf(OverTryCountException.class);
    }

    @Test
    @DisplayName("(생성자 입력) 시도 기준을 초과하면 예외가 발생한다.")
    void overTryCountByConstructor() {
        assertThatThrownBy(() -> new TryCount("3", "4"))
                .isInstanceOf(OverTryCountException.class);
    }
}
