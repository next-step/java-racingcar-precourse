package racingCar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @DisplayName("이름의 길이가 5를 초과하면 예외처리")
  @Test
  void create() {
    assertThatThrownBy(() -> new Name("jdragon"))
        .isInstanceOf(ExceedCarNameException.class)
        .hasMessage("자동차 이름의 길이가 5를 초과했습니다.");
  }

}