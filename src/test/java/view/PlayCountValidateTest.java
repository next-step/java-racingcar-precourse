package view;

import controller.ValidateInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CarUtility;

public class PlayCountValidateTest {

  @Test
  @DisplayName("시도 횟수가 제대로 입력된 케이스")
  void carNames_correctCase() {
    // given
    String correctCase = "3";
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.playCountValidate(correctCase);
    // then
    Assertions.assertThat(validateResult).isEqualTo(true);
  }

  @Test
  @DisplayName("시도 회수가 숫자가 아닌 케이스")
  void carNames_errorCase_not_number() {
    // given
    String errorCase = "abc";
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.playCountValidate(errorCase);
    // then
    Assertions.assertThat(validateResult).isEqualTo(false);
  }

  @Test
  @DisplayName("시도 회수가 음의 정수인 케이스")
  void carNames_errorCase_negative_playCount() {
    // given
    String errorCase = "-1";
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.playCountValidate(errorCase);
    // then
    Assertions.assertThat(validateResult).isEqualTo(false);
  }

  @Test
  @DisplayName("시도 회수가 0인 케이스")
  void carNames_errorCase_zero_playCount() {
    // given
    String errorCase = "0";
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.playCountValidate(errorCase);
    // then
    Assertions.assertThat(validateResult).isEqualTo(false);
  }
}
