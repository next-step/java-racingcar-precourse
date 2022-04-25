package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.message.ERRORMessage;

class ValidateUtilTest {

    @Test
    @DisplayName("문자 배열에서 5자 확인 확인")
    void 문자_배열에서_5자_이하_조건_확인() {
        //given
        List<String> carNames = Arrays.asList("Test1", "Test2", "Test 3");

        //when, then
        assertThatThrownBy(() -> ValidateUtil.validateNames(carNames)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERRORMessage.CAR_NAME_VALIDATE_FIVE_CHARACTER);
    }

    @Test
    @DisplayName("문자 배열에서 공백 확인 확인")
    void 문자_배열에서_공백_조건_확인() {
        //given
        List<String> carNames = Arrays.asList("Test1", "", "Test 3");

        //when, then
        assertThatThrownBy(() -> ValidateUtil.validateNames(carNames)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERRORMessage.CAR_NAME_VALIDATE_BLANK);
    }

}