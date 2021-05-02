package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

  @Test
  @DisplayName("문자열을 split한 후, 변환할 Function을 통해 List로 변환한다.")
  void toList() {
    // given
    String str = "gmoon,guest";
    String separator = ",";

    // when
    List<Car> actual = StringUtil.toList(str, separator, Car::new);

    // then
    assertThat(actual).containsExactly(new Car("gmoon"), new Car("guest"));
  }

  @Test
  @DisplayName("문자열과 특정 문자열로 문자열 배열로 반환한다.")
  void split() {
    // given
    String str = "gmoon,guest";
    String separator = ",";

    // when
    String[] actual = StringUtil.split(str, separator);

    // then
    assertThat(actual).containsExactly("gmoon", "guest");
  }
}