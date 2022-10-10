package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilsTest {
    @DisplayName("알파벳 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void isAlphabetTest(String given) {
        assertThat(Utils.isAlphabet(given)).isTrue();
    }

    @DisplayName("0~9 범위의 임의의 숫자 생성 테스트")
    @Test
    void generateRandomNumberTest() {
            assertThat(Utils.generateRandomNumber()).isBetween(0, 9);
    }

    @DisplayName("tryCount 검증 테스트")
    @Test
    void validateTryCountTest() {
        assertThatThrownBy(() -> Utils.validateTryCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상의 숫자만 입력 가능합니다.");

        assertThatThrownBy(() -> Utils.validateTryCount("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @DisplayName("separateInput 테스트")
    @Test
    void separateInputTest() {
        assertThat(Utils.separateInput("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }
}
