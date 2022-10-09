package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.code.Message;

public class ValidationUtilTest {


  @Test
  @DisplayName("자동차 이름 공백 체크 공백이나 null인 경우 IllegalArgumentException")
  void 자동차이름공백체크() {
    List<String> nullCheckList = Arrays.asList("", null);
    nullCheckList.forEach(name ->
            assertThatThrownBy(() -> ValidationUtil.isNull(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_INPUT_BLANK.getMsg())
        );
  }

  @ParameterizedTest
  @DisplayName("자동차 이름 5자 이하만 허용  초과시 IllegalArgumentException")
  @ValueSource(strings ={"carNam","testName2","testName33"})
  void 자동차이름유효성검사(String name) {
    assertThatThrownBy(() -> ValidationUtil.isMaxLength(name)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Message.ERROR_NAME_LENGTH.getMsg());
  }

}
