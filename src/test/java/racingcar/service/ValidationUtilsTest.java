package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.messenger.ValidationUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilsTest {

    @DisplayName("리스트로 받은 이름의 길이를 체크한다. - 길이가 5 이상일 경우")
    @Test
    void validateNameLength() {
        // given
        List<String> nameList = Arrays.asList("pobinon", "sun", "jo");

        // when & then
        assertThatThrownBy(
            () -> ValidationUtils.validateNameLength(nameList)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수를 입력받는다. - 숫자와 문자가 있을 경우")
    @Test
    void validateMoveNum_1() {
        // given
        String moveNum = "12a";
        // when & then
        assertThatThrownBy(
                () -> ValidationUtils.validateMoveNum(moveNum)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도할 횟수를 입력받는다. - 문자만 있을 경우")
    @Test
    void validateMoveNum_2() {
        // given
        String moveNum = "aa";
        // when & then
        assertThatThrownBy(
                () -> ValidationUtils.validateMoveNum(moveNum)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
