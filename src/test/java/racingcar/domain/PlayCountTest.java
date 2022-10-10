package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Number;

import static org.assertj.core.api.Assertions.assertThat;

class PlayCountTest {

    @DisplayName("시도할 횟수가 0이하이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -100})
    void 시도할_횟수가_0이하이면_예외가_발생한다(int count) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> new PlayCount(count))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageStartingWith("[ERROR] 시도할 회수는 " + Number.ZERO + "보다 작을 수 없습니다.");
    }

    @DisplayName("시도할 횟수를 조회한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10})
    void 시도할_횟수를_조회한다(int count) {
        // given
        PlayCount playCount = new PlayCount(count);

        // when
        // then
        assertThat(playCount.getCount()).isEqualTo(count);
    }
}