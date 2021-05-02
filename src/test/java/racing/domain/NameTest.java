package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.NameLengthExceedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class NameTest {

  @Test
  @DisplayName("자동차 이름 길이는 5를 초과할 수 없다.")
  void newInstance() {
    assertAll(
            () -> assertThat(new Name("gmoon")).isEqualTo(new Name("gmoon")),
            () -> assertThatExceptionOfType(NameLengthExceedException.class)
                    .isThrownBy(() -> new Name("123456"))
                    .withMessageMatching("자동차 이름은 \\d+자 이하만 가능하다."));
  }
}