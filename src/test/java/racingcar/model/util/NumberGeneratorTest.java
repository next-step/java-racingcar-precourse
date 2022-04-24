package racingcar.model.util;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest implements NumberGenerator {
    final int MIN = 10;
    final int MAX = 11;

    @Test
    void 랜덤_범위_OUT_테스트() {
        // given
        // when
        // then
        assertThat(generateNumber() > 9).isEqualTo(true);
    }

    @Override
    public int generateNumber() {
        return pickNumberInRange(MIN, MAX);
    }
}