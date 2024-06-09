package util;
import RacingCar.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

  @Test
  @DisplayName("유효한 자동차 이름 입력 테스트")
  void testValidCarNames() {
    List<String> carNames = InputValidator.checkCarValid("pobi,woni,jun");
    assertEquals(List.of("pobi", "woni", "jun"), carNames);
  }

  @Test
  @DisplayName("자동차 이름에 빈 이름이 포함된 경우 예외 발생")
  void testBlankCarName() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkCarValid("pobi, ,woni");
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkCarValid("huh, woni, , pobi");
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
  void testLongCarName() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkCarValid("pobi,woni,verylongname");
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("중복된 자동차 이름이 있는 경우 예외 발생")
  void testDuplicateCarName() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkCarValid("pobi,woni,pobi");
    });
    assertEquals("[ERROR] 중복된 자동차 이름이 있습니다: pobi", exception.getMessage());
  }

  @Test
  @DisplayName("유효한 시도 횟수 입력 테스트")
  void testValidAttempt() {
    int attempts = InputValidator.checkAttemptValid("5");
    assertEquals(5, attempts);
  }

  @Test
  @DisplayName("시도 횟수가 1 미만인 경우 예외 발생")
  void testInvalidAttemptBelowOne() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkAttemptValid("0");
    });
    assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkAttemptValid("-1");
    });
    assertEquals("[ERROR] 시도 횟수는 1 이상이어야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("유효하지 않은 시도 횟수 입력 테스트")
  void testInvalidAttemptNonNumeric() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkAttemptValid("abc");
    });
    assertEquals("[ERROR] 1 이상의 자연수를 입력해주세요.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {
      InputValidator.checkAttemptValid("");
    });
    assertEquals("[ERROR] 1 이상의 자연수를 입력해주세요.", exception.getMessage());
  }
}
