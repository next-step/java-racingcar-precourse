package racingcar.common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.ValidationCheck.carNamelengthValidation;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidationCheckTest {
    @Test
    void 자동차_이름_길이_정합성_검사() {
        assertThat(carNamelengthValidation("car")).isEqualTo(true);
        assertThat(carNamelengthValidation("racingCar")).isEqualTo(false);
    }

}
