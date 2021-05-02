package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

  @Test
  @DisplayName("자동차 일급 컬렉션 생성 테스트, 자동차 이름은 쉼표(\",\")로 구분한다.")
  void generateFromInputString() {
    // given
    String input = "gmoon,guest";

    // when
    Cars actual = Cars.generateFromInputString(input);

    // then
    assertThat(actual.getValues())
            .containsExactly(new Car("gmoon"), new Car("guest"));
  }
}