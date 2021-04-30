package homework.racegame.util;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationCheckerTest {

    @Test
    @DisplayName("사용자 시도 횟수 입력 정상 여부 확인")
    public void isValidTryCountTest() {
        assertThat(ValidationChecker.isValidTryCount("1")).isTrue();
        assertThat(ValidationChecker.isValidTryCount("12")).isTrue();
        assertThat(ValidationChecker.isValidTryCount("312")).isTrue();
        assertThat(ValidationChecker.isValidTryCount("1A")).isFalse();
        assertThat(ValidationChecker.isValidTryCount("A2")).isFalse();
        assertThat(ValidationChecker.isValidTryCount("2#2")).isFalse();
        assertThat(ValidationChecker.isValidTryCount("AAA")).isFalse();
        assertThat(ValidationChecker.isValidTryCount("0")).isTrue();
    }

    @Test
    @DisplayName("사용자 차량 이름 입력 정상 여부 확인")
    public void isValidCarNameTest() {
        String[] validCarNames = new String[]{"abc", "bcd", "qweaa", "A12", "xcx2"};
        String[] inValidCarNames = new String[]{"abc", "bcd", "qweaaA", "A12", "xcx2"};
        assertThat(ValidationChecker.isValidCarName(validCarNames)).isTrue();
        assertThat(ValidationChecker.isValidCarName(inValidCarNames)).isFalse();
    }
}
