package racinggame;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class ValidationUtilsTest {

  @Test
  @DisplayName("자동차_이름_5자리_이하")
  void carNameLessThan5word() {
    assertThat(ValidationUtils.carNameLessThan5words("toyota")).isFalse();
    assertThat(ValidationUtils.carNameLessThan5words("hyundai")).isFalse();
    assertThat(ValidationUtils.carNameLessThan5words("kia")).isTrue();
    assertThat(ValidationUtils.carNameLessThan5words("volvo")).isTrue();
    assertThat(ValidationUtils.carNameLessThan5words("benz")).isTrue();
  }

}
