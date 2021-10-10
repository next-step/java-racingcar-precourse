package nextstep.utils;

import org.junit.jupiter.api.Test;

import static nextstep.utils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racinggame.domain.GameConfig.END_INCLUSIVE;
import static racinggame.domain.GameConfig.START_INCLUSIVE;

class RandomsTest {
    @Test
    void 랜덤값_생성_시_스택오버플로우_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    pickNumberInRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
                }).withMessageMatching("끝값이 너무 큽니다. \\(스택 오버플로우 발생이 가능합니다\\)");
    }

    @Test
    void 랜덤값_생성_시_잘못된_범위가_입력되는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    pickNumberInRange(END_INCLUSIVE.getValue(), START_INCLUSIVE.getValue());
                }).withMessageMatching("startInclusive가 endInclusive보다 클 수 없습니다.");
    }

    @Test
    void 랜덤값의_최소값_최대값의_범위() {
        assertThat(pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue()))
                .isGreaterThanOrEqualTo(START_INCLUSIVE.getValue())
                .isLessThanOrEqualTo(END_INCLUSIVE.getValue());
    }
}