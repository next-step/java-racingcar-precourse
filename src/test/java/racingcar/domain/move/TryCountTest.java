package racingcar.domain.move;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {

    @Test
    void 시도_횟수를_하나씩_감소한다() {
        TryCount tryCount = new TryCount(3);

        assertThat(tryCount.letsTry()).isTrue();
        assertThat(tryCount.letsTry()).isTrue();
        assertThat(tryCount.letsTry()).isTrue();
        assertThat(tryCount.letsTry()).isFalse();
    }
}
