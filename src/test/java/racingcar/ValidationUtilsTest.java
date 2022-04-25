package racingcar;

import org.junit.jupiter.api.Test;
import utils.CommonUtils;
import utils.ValidationUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {
    @Test
    void 자동차_이름_길이() {
        assertThat(ValidationUtils.validateCarName("apple")).isTrue();
        assertThat(ValidationUtils.validateCarName("sonata")).isFalse();
    }

    @Test
    void 입력_자동차_개수() {
        assertThat(ValidationUtils.validateCarCount(new String[]{"dog", "cat"})).isTrue();
        assertThat(ValidationUtils.validateCarCount(new String[]{"apple"})).isFalse();
    }

    @Test
    void 자동차_이름_중복() {
        assertThat(ValidationUtils.validateUniqueCarName(new String[]{"dog", "cat", "dog"})).isFalse();
        assertThat(ValidationUtils.validateUniqueCarName(new String[]{"matiz", "pride", "tico"})).isTrue();
    }

    @Test
    void 전진_시도_횟수_숫자_테스트() {
        assertThat(CommonUtils.isNumeric("abcd")).isFalse();
        assertThat(CommonUtils.isNumeric("12")).isTrue();
    }
}
