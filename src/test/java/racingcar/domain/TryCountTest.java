package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("시도횟수는 숫자만 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "1000", "0"})
    void number(String number) {

        TryCount tryCount = new TryCount(number);
        assertThat(tryCount).isInstanceOf(TryCount.class);
    }

    @DisplayName("시도횟수는 0회 미만이면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10", "-1000"})
    void zero(String number) {

        assertThatThrownBy(() -> new TryCount(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수가 숫자가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "가나다", "abc"})
    void numberException(String number) {

        assertThatThrownBy(() -> new TryCount(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도횟수가 1회 이상이면 남아있는 기회는 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void hasChance(String number) {
        TryCount tryCount = new TryCount(number);
        assertThat(tryCount.hasTryCount()).isTrue();
    }

    @DisplayName("시도횟수가 1회 있을때 한번 실행하면 남아 있는 기회는 없다.")
    @Test
    void hasNoChance() {
        TryCount tryCount = new TryCount("1");
        tryCount.tryOnce();
        assertThat(tryCount.hasTryCount()).isFalse();
    }

}
