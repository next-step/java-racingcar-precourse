package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TryCountTest {
    private static final int VALID_TRY_COUNT = 1;
    private static final int INVALID_TRY_COUNT = 0;

    @Test
    @DisplayName("시도횟수는 최소 1이상이어야 한다")
    void 시도횟수는_최소_1이상이어야_한다() {
        assertThat(TryCount.from(VALID_TRY_COUNT)).isNotNull();
        assertThatThrownBy(() -> TryCount.from(INVALID_TRY_COUNT)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
