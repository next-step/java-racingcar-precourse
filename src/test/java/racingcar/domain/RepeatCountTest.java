package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.Messages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RepeatCountTest {

    @Test
    void 게임_반복_횟수를_정한다() {
        RepeatCount repeatCount = new RepeatCount("1");

        // then
        Assertions.assertThat(repeatCount.getCount()).isEqualTo(1);
    }

    @Test
    void 게임_반복_횟수를_3으로_정한다() {
        RepeatCount repeatCount = new RepeatCount("3");

        // then
        Assertions.assertThat(repeatCount.getCount()).isEqualTo(3);
    }

    @Test
    void 게임_횟수가_NULL인_경우_에러() {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RepeatCount(null))
                .withMessageContaining(Messages.REPEAT_NOT_NUMBER);
    }

    @Test
    void 게임_횟수가_0인_경우_에러() {
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RepeatCount("0"))
                .withMessageContaining(Messages.REPEAT_NOT_ZERO);
    }
}
