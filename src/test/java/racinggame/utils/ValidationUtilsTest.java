package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidationUtilsTest {

    @Test
    @DisplayName(value = "자동차 이름 - 5글자 초과시 false 반환")
    public void 자동차이름_다섯글자넘어가면오류() {
        assertThat(ValidationUtils.validateCarNameLength("aaaaaa"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "자동차 이름 - 5글자 이하면 통과")
    public void 자동차이름_글자수통과() {
        assertThat(ValidationUtils.validateCarNameLength("aaaaa"))
                .isEqualTo(true);
    }

    @Test
    @DisplayName(value = "자동차들 이름 - 5글자 초과 있으면 false 반환")
    public void 자동차들이름_다섯글자넘어가는거있으면오류() {
        assertThat(ValidationUtils.validateCarNameLength("navi,dooly,hoomay"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "자동차들 이름 - 5글자 초과 없으면 통과")
    public void 자동차들이름_다섯글자안넘으면통과() {
        assertThat(ValidationUtils.validateCarNameLength("navi,dooly,hooma"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "자동차들 이름 - 중복 false 반환")
    public void 자동차들이름_중복오류() {
        assertThat(ValidationUtils.validateCarNameLength("navi,dooly,dooly"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "시도 횟수 - 음수인 경우 false 반환")
    public void 시도횟수_음수일경우오류() {
        assertThat(ValidationUtils.validateTryNo("-1"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "시도 횟수 - 숫자가 아닐경우 false 반환")
    public void 시도횟수_숫자가아닌경우() {
        assertThat(ValidationUtils.validateTryNo("-1"))
                .isEqualTo(false);
    }

    @Test
    @DisplayName(value = "시도 횟수 - 양수인 경우 통과")
    public void 시도횟수_양수인경우통과() {
        assertThat(ValidationUtils.validateTryNo("1"))
                .isEqualTo(true);
    }
}