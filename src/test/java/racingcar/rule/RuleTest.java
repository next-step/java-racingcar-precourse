package racingcar.rule;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RuleTest {

    @Test
    void 랜덤숫자() {

        Assertions.assertThat(Randoms.pickNumberInRange(0, 9)).isLessThanOrEqualTo(10);
    }

}
