package view;

import controller.ValidateInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CarUtility;

public class CarNamesValidateTest {

  @Test
  @DisplayName("자동차 이름들이 제대로 생성된 케이스")
  void carNames_correctCase() {
    // given
    String correctCase = "abc,def,ghi";
    CarUtility carUtility = new CarUtility();
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.carNamesValidate(carUtility.carNamesSplit(correctCase));
    // then
    Assertions.assertThat(validateResult).isEqualTo(true);
  }

  @Test
  @DisplayName("자동차 이름이 5글자 보다 긴 케이스")
  void carNames_errorCase_longerThan5() {
    // given
    String errorCase = "abc,defghi";
    CarUtility carUtility = new CarUtility();
    // when
    ValidateInput validateInput = new ValidateInput();
    boolean validateResult = validateInput.carNamesValidate(carUtility.carNamesSplit(errorCase));
    // then
    Assertions.assertThat(validateResult).isEqualTo(false);
  }
}
