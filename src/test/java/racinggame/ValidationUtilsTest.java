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
    assertThat(ValidationUtils.isCarNameLessThan5words("toyota")).isFalse();
    assertThat(ValidationUtils.isCarNameLessThan5words("hyundai")).isFalse();
    assertThat(ValidationUtils.isCarNameLessThan5words("kia")).isTrue();
    assertThat(ValidationUtils.isCarNameLessThan5words("volvo")).isTrue();
    assertThat(ValidationUtils.isCarNameLessThan5words("benz")).isTrue();
  }

  @Test
  void isNum() {
    assertThat(ValidationUtils.isNum("1")).isTrue();
    assertThat(ValidationUtils.isNum("test")).isFalse();
  }

}
